package ie.ucd.dodgycoders.goodsservice.api;

import ie.ucd.dodgycoders.goodsservice.api.model.Goods;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link GoodsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-24T11:21:23.548Z[Europe/Dublin]")
public interface GoodsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /goods : Find all goods
     * Get all goods by a single call
     *
     * @return successful operation (status code 200)
     *         or Invalid itemId supplied (status code 400)
     *         or Item not found (status code 404)
     * @see GoodsApi#goodsGet
     */
    default ResponseEntity<List> goodsGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"itemId\" : 10, \"price\" : \"$799.99\", \"name\" : \"iphone14\", \"stock\" : 99 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /goods/{itemId} : Find an item by id
     * Get an item by its id
     *
     * @param itemId Item to return (required)
     * @return successful operation (status code 200)
     *         or Invalid itemId supplied (status code 400)
     *         or Item not found (status code 404)
     * @see GoodsApi#goodsItemIdGet
     */
    default ResponseEntity<Goods> goodsItemIdGet(Long itemId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"itemId\" : 10, \"price\" : \"$799.99\", \"name\" : \"iphone14\", \"stock\" : 99 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
