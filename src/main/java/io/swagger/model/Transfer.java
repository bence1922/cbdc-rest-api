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
 * Information for transfer.
 */
@Schema(description = "Information for transfer.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-26T07:47:02.189Z[GMT]")


public class Transfer   {
  @JsonProperty("fromAddress")
  private String fromAddress = null;

  @JsonProperty("toAddress")
  private String toAddress = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("nonce")
  private BigDecimal nonce = null;

  @JsonProperty("v")
  private String v = null;

  @JsonProperty("r")
  private String r = null;

  @JsonProperty("s")
  private String s = null;

  public Transfer fromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
    return this;
  }

  /**
   * Get fromAddress
   * @return fromAddress
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getFromAddress() {
    return fromAddress;
  }

  public void setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
  }

  public Transfer toAddress(String toAddress) {
    this.toAddress = toAddress;
    return this;
  }

  /**
   * Get toAddress
   * @return toAddress
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getToAddress() {
    return toAddress;
  }

  public void setToAddress(String toAddress) {
    this.toAddress = toAddress;
  }

  public Transfer amount(BigDecimal amount) {
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

  public Transfer nonce(BigDecimal nonce) {
    this.nonce = nonce;
    return this;
  }

  /**
   * Get nonce
   * @return nonce
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getNonce() {
    return nonce;
  }

  public void setNonce(BigDecimal nonce) {
    this.nonce = nonce;
  }

  public Transfer v(String v) {
    this.v = v;
    return this;
  }

  /**
   * Get v
   * @return v
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getV() {
    return v;
  }

  public void setV(String v) {
    this.v = v;
  }

  public Transfer r(String r) {
    this.r = r;
    return this;
  }

  /**
   * Get r
   * @return r
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getR() {
    return r;
  }

  public void setR(String r) {
    this.r = r;
  }

  public Transfer s(String s) {
    this.s = s;
    return this;
  }

  /**
   * Get s
   * @return s
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transfer transfer = (Transfer) o;
    return Objects.equals(this.fromAddress, transfer.fromAddress) &&
        Objects.equals(this.toAddress, transfer.toAddress) &&
        Objects.equals(this.amount, transfer.amount) &&
        Objects.equals(this.nonce, transfer.nonce) &&
        Objects.equals(this.v, transfer.v) &&
        Objects.equals(this.r, transfer.r) &&
        Objects.equals(this.s, transfer.s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromAddress, toAddress, amount, nonce, v, r, s);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transfer {\n");
    
    sb.append("    fromAddress: ").append(toIndentedString(fromAddress)).append("\n");
    sb.append("    toAddress: ").append(toIndentedString(toAddress)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("    v: ").append(toIndentedString(v)).append("\n");
    sb.append("    r: ").append(toIndentedString(r)).append("\n");
    sb.append("    s: ").append(toIndentedString(s)).append("\n");
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
