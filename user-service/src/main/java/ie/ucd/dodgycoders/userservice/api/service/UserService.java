package ie.ucd.dodgycoders.userservice.api.service;

import ie.ucd.dodgycoders.userservice.api.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    //Create this GoodService interface for the controller to call
    User findByUsernameAndPasswordNotNull(String username, String password);
}
