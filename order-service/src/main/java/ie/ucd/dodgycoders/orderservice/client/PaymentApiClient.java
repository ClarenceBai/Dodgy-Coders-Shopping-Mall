package ie.ucd.dodgycoders.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;

import ie.ucd.dodgycoders.paymentservice.api.PaymentApi;
import ie.ucd.dodgycoders.paymentservice.api.config.ClientConfiguration;

@FeignClient(name = "${payment.name:payment-service/api}", url = "http://payment-service/api", configuration = ClientConfiguration.class)
public interface PaymentApiClient extends PaymentApi {
}
