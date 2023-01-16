package ie.ucd.dodgycoders.paymentservice.api.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Payment
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-11-24T14:20:31.787Z[Europe/Dublin]")
public class Payment {

  @JsonProperty("userId")
  private Long userId;

  @JsonProperty("amount")
  private Integer amount;

  @JsonProperty("paymentPlacedTime")
  private OffsetDateTime paymentPlacedTime = null;

  /**
   * payment status
   */
  public enum PaymentStatusEnum {
    PENDDING("pendding"),
    
    COMPLETED("completed"),
    
    CANCLED("cancled");

    private String value;

    PaymentStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PaymentStatusEnum fromValue(String value) {
      for (PaymentStatusEnum b : PaymentStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("paymentStatus")
  private PaymentStatusEnum paymentStatus;

  public Payment userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", example = "1", required = true)
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Payment amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull 
  @Schema(name = "amount", example = "66", required = true)
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Payment paymentPlacedTime(OffsetDateTime paymentPlacedTime) {
    this.paymentPlacedTime = paymentPlacedTime;
    return this;
  }

  /**
   * Get paymentPlacedTime
   * @return paymentPlacedTime
  */
  @Valid 
  @Schema(name = "paymentPlacedTime", example = "2022-11-11T15:30:45Z", required = false)
  public OffsetDateTime getPaymentPlacedTime() {
    return paymentPlacedTime;
  }

  public void setPaymentPlacedTime(OffsetDateTime paymentPlacedTime) {
    this.paymentPlacedTime = paymentPlacedTime;
  }

  public Payment paymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

  /**
   * payment status
   * @return paymentStatus
  */
  @NotNull 
  @Schema(name = "paymentStatus", example = "pendding", description = "payment status", required = true)
  public PaymentStatusEnum getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.userId, payment.userId) &&
        Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.paymentPlacedTime, payment.paymentPlacedTime) &&
        Objects.equals(this.paymentStatus, payment.paymentStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, amount, paymentPlacedTime, paymentStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    paymentPlacedTime: ").append(toIndentedString(paymentPlacedTime)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
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

