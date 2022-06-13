package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information for transfer check.
 */
@Schema(description = "Information for transfer check.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-13T09:09:20.233Z[GMT]")


public class TransferInformation   {
  @JsonProperty("from")
  private String from = null;

  @JsonProperty("to")
  private String to = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("transactionId")
  private String transactionId = null;

  public TransferInformation from(String from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public TransferInformation to(String to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public TransferInformation amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public TransferInformation transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * Get transactionId
   * @return transactionId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferInformation transferInformation = (TransferInformation) o;
    return Objects.equals(this.from, transferInformation.from) &&
        Objects.equals(this.to, transferInformation.to) &&
        Objects.equals(this.amount, transferInformation.amount) &&
        Objects.equals(this.transactionId, transferInformation.transactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, amount, transactionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferInformation {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
