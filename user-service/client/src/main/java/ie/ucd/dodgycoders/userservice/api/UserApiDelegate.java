package ie.ucd.dodgycoders.userservice.api;

import java.time.OffsetDateTime;

import ie.ucd.dodgycoders.userservice.api.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link UserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-25T10:21:30.661Z[Europe/Dublin]")
public interface UserApiDelegate {

    /**
     * GET /user/login : Logs user into the system
     * 
     *
     * @param username The user name for login (optional)
     * @param password The password for login in clear text (optional)
     * @return successful operation (status code 200)
     *         or Invalid username/password supplied (status code 400)
     * @see UserApi#findByUsernameAndPassword
     */
    public ResponseEntity<String> loginUser(String username,
                                                   String password);

}
