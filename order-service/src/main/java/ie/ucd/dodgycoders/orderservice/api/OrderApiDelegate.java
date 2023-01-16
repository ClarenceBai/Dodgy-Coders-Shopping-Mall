package ie.ucd.dodgycoders.orderservice.api;

import ie.ucd.dodgycoders.orderservice.api.model.Order;
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
 * A delegate to be called by the {@link OrderApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-14T17:27:04.945Z[Europe/Dublin]")
public interface OrderApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /order
     *
     * @param order Place an order (optional)
     * @return successful operation (status code 200)
     *         or Validation exception (status code 405)
     *         or fail to place the order (status code 500)
     * @see OrderApi#orderPut
     */
    default ResponseEntity<Order> orderPut(Order order) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"totalAmount\" : 325.53, \"id\" : 100000, \"complete\" : false, \"userId\" : 10, \"orderItems\" : [ { \"quantity\" : 3, \"goodsNname\" : \"Macboook\", \"goodsId\" : 1353, \"price\" : 1500 }, { \"quantity\" : 3, \"goodsNname\" : \"Macboook\", \"goodsId\" : 1353, \"price\" : 1500 } ], \"orderDate\" : \"2022-11-12T17:32:28Z\", \"status\" : \"placed\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
