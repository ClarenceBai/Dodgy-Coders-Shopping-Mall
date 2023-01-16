package ie.ucd.dodgycoders.orderservice.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderItem
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-14T17:27:04.945Z[Europe/Dublin]")
public class OrderItem {

  @JsonProperty("goodsId")
  private Long goodsId;

  @JsonProperty("goodsNname")
  private String goodsNname;

  @JsonProperty("price")
  private Float price;

  @JsonProperty("quantity")
  private Long quantity;

  public OrderItem goodsId(Long goodsId) {
    this.goodsId = goodsId;
    return this;
  }

  /**
   * Get goodsId
   * @return goodsId
  */
  @NotNull 
  @Schema(name = "goodsId", example = "1353", required = true)
  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  public OrderItem goodsNname(String goodsNname) {
    this.goodsNname = goodsNname;
    return this;
  }

  /**
   * Get goodsNname
   * @return goodsNname
  */
  
  @Schema(name = "goodsNname", example = "Macboook", required = false)
  public String getGoodsNname() {
    return goodsNname;
  }

  public void setGoodsNname(String goodsNname) {
    this.goodsNname = goodsNname;
  }

  public OrderItem price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @NotNull 
  @Schema(name = "price", example = "1500", required = true)
  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public OrderItem quantity(Long quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull 
  @Schema(name = "quantity", example = "3", required = true)
  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.goodsId, orderItem.goodsId) &&
        Objects.equals(this.goodsNname, orderItem.goodsNname) &&
        Objects.equals(this.price, orderItem.price) &&
        Objects.equals(this.quantity, orderItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(goodsId, goodsNname, price, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    sb.append("    goodsId: ").append(toIndentedString(goodsId)).append("\n");
    sb.append("    goodsNname: ").append(toIndentedString(goodsNname)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

