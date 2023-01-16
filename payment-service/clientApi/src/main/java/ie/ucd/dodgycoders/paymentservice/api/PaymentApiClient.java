package ie.ucd.dodgycoders.paymentservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import ie.ucd.dodgycoders.paymentservice.api.config.ClientConfiguration;

@FeignClient(name="${payment.name:payment}", url="${payment.url:http://localhost:9003/api}", configuration = ClientConfiguration.class)
public interface PaymentApiClient extends PaymentApi {
}
