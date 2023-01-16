package ie.ucd.dodgycoders.orderservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import ie.ucd.dodgycoders.orderservice.api.config.ClientConfiguration;

@FeignClient(name="${order.name:order}", url="${order.url:http://localhost:9001/api}", configuration = ClientConfiguration.class)
public interface OrderApiClient extends OrderApi {
}
