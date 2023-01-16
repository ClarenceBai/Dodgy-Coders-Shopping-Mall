package ie.ucd.dodgycoders.goodsservice.api;

import ie.ucd.dodgycoders.goodsservice.api.GoodsApi;
import ie.ucd.dodgycoders.goodsservice.api.GoodsApiDelegate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-24T11:21:23.548Z[Europe/Dublin]")
@Controller
@RequestMapping("${openapi.dodgyDriversOnlineMallOpenAPI30.base-path:/api}")
public class GoodsApiController implements GoodsApi {

    private final GoodsApiDelegate delegate;

    public GoodsApiController(@Autowired(required = false) GoodsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new GoodsApiDelegate() {});
    }

    @Override
    public GoodsApiDelegate getDelegate() {
        return delegate;
    }

}
