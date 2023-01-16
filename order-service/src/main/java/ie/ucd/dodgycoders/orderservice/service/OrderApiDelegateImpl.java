package ie.ucd.dodgycoders.orderservice.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ie.ucd.dodgycoders.orderservice.api.OrderApiDelegate;
import ie.ucd.dodgycoders.orderservice.api.model.Order;
import ie.ucd.dodgycoders.orderservice.repository.OrderDoc;
import ie.ucd.dodgycoders.orderservice.repository.OrderRepository;
import ie.ucd.dodgycoders.paymentservice.api.PaymentApi;
import ie.ucd.dodgycoders.paymentservice.api.model.Payment;
import ie.ucd.dodgycoders.paymentservice.api.model.Payment.PaymentStatusEnum;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.vavr.control.Try;

@Service
public class OrderApiDelegateImpl implements OrderApiDelegate {
    private static final Logger logger = LoggerFactory.getLogger(OrderApiDelegateImpl.class);

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentApi paymentApi;

    private AtomicLong idGenerator = new AtomicLong();

    private Random random = new Random();

    @Override
    public ResponseEntity<Order> orderPut(Order order) {
        logger.info("new request:", order);
        // set new id
        order.id(idGenerator.incrementAndGet());

        // Below code is used to manually increase CPU usage to test the scale up
        // feature
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
        }

        int j = 0;
        for (int i = 10; i < 10000; i++) {
            j += (int) Math.log(random.nextInt(i) + 1);
        }

        // MongoDB code is tested to be working, however when we record the video
        // in UCD we couldn't connect to MongoDB Atlas, so the real database operation
        // is disable.

        // System.out.println("-->Order count: " + orderRepository.count());
        // create new order in mongodb
        // orderRepository.save(OrderDoc.factory(order));

        ResponseEntity<Void> result = payOrder(order);
        if (result.getStatusCode() == HttpStatus.OK) {
            logger.info("ok");
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            logger.info("NOT ok");
            return new ResponseEntity<>(new Order(), result.getStatusCode());
        }
    }

    public ResponseEntity<Void> payOrder(Order order) {
        Payment payment = new Payment().userId(order.getUserId())
                .amount(Math.round(order.getTotalAmount()))
                .paymentStatus(PaymentStatusEnum.PENDDING)
                .paymentPlacedTime(OffsetDateTime.now());
        // Supplier code which invokes the payment service
        Supplier<ResponseEntity<Void>> supplier = () -> {
            logger.info("Request paymentApi.addPayment(), args: " + payment);
            ResponseEntity<Void> result = paymentApi.addPayment(payment);
            logger.info("Request paymentApi.addPayment(), args: " + " DONE.");
            return result;
        };

        // Apply Circuit breaker to payment service call. Use default configurations.
        // Reference:
        // https://github.com/spring-cloud-samples/spring-cloud-circuitbreaker-demo/blob/main/spring-cloud-circuitbreaker-demo-resilience4j/src/main/java/org/springframework/cloud/circuitbreaker/demo/resilience4jcircuitbreakerdemo/DemoController.java
        // Default config:
        // https://github.com/spring-cloud/spring-cloud-circuitbreaker/blob/main/spring-cloud-circuitbreaker-resilience4j/src/main/java/org/springframework/cloud/circuitbreaker/resilience4j/Resilience4JConfigBuilder.java
        // Go into the ofDefaults() methods below to check the default configurations.
        // TimeLimiterConfig.ofDefaults();
        // CircuitBreakerConfig.ofDefaults();
        return circuitBreakerFactory.create("pay order")
                .run(supplier, t -> {
                    logger.warn("pay order error", t);
                    // use http code "408 Request Timeout" for fallback
                    ResponseEntity<Void> fallback = ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
                    return fallback;
                });
    }

}
