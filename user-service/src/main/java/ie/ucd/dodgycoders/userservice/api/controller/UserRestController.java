package ie.ucd.dodgycoders.userservice.api.controller;

import ie.ucd.dodgycoders.userservice.api.model.User;
import ie.ucd.dodgycoders.userservice.api.service.UserService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;


@RestController
public class UserRestController {
    private final Bucket bucket;

    public UserRestController() {
        Bandwidth limit = Bandwidth.classic(40, Refill.greedy(40, Duration.ofSeconds(1)));
        this.bucket = Bucket4j.builder()
                        .addLimit(limit)
                        .build();
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login/username={username}&password={password}", method = RequestMethod.GET)
    public ResponseEntity<String> loginUser(@PathVariable("username") String username,
                                          @PathVariable("password") String password){
        User response;
        if  (bucket.tryConsume(1)) {
            try{
                //get response by calling GoodsService
                response = userService.findByUsernameAndPasswordNotNull(username, password);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("The username or password is not valid",HttpStatus.BAD_REQUEST);
            }
            if(response == null) {
                return new ResponseEntity<>("The username or password is not valid",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Log In Successfully",HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
}
