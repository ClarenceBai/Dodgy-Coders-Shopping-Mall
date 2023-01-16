package ie.ucd.dodgycoders.userservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import ie.ucd.dodgycoders.userservice.api.config.ClientConfiguration;

@FeignClient(name="${user.name:user}", url="${user.url::http://localhost:9004/api}", configuration =
                ClientConfiguration.class)
public interface UserApiClient extends UserApi {
}
