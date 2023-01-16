package ie.ucd.dodgycoders.userservice.api.service;

import ie.ucd.dodgycoders.userservice.api.model.User;
import ie.ucd.dodgycoders.userservice.api.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepo;

    @Override
    public User findByUsernameAndPasswordNotNull(String username, String password) {
        logger.info("new request", username);
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j += (int) Math.log(i);
        }

        //return userRepo.findByUsernameAndPasswordNotNull(username, password);
        logger.info("return ...");
        return new User();
    }
}