package ie.ucd.dodgycoders.gatewayserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @RequestMapping(value = "/gatewayFallback", 
    method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<String> gatewayFallback() {
        return new ResponseEntity<>(
                "Sorry, we are facing some problem with gateway, please contact DodgyCoders helpdesk!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/goodsFallback", 
    method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<String> goodsFallback() {
        return new ResponseEntity<>(
                "Sorry, we are facing some problem wtih goods service, please contact DodgyCoders helpdesk!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/orderFallback", 
    method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<String> orderFallback() {
        return new ResponseEntity<>(
                "Sorry, we are facing some problem with order service, please contact DodgyCoders helpdesk!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/userFallback", 
    method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<String> userFallback() {
        return new ResponseEntity<>(
                "Sorry, we are facing some problem with user service, please contact DodgyCoders helpdesk!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/paymentFallback", 
    method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<String> paymentFallback() {
        return new ResponseEntity<>(
                "Sorry, we are facing some problem with payment service, please contact DodgyCoders helpdesk!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}