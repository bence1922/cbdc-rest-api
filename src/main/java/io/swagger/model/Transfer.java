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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-13T09:09:20.233Z[GMT]")


public class Transfer   {
  @JsonProperty("from")
  private String from = null;

  @JsonProperty("to")
  private String to = null;

  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("pocket")
  private String pocket = null;

  @JsonProperty("nonce")
  private BigDecimal nonce = null;

  @JsonProperty("v")
  private String v = null;

  @JsonProperty("r")
  private String r = null;

  @JsonProperty("s")
  private String s = null;

  public Transfer from(String from) {
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

  public Transfer to(String to) {
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

  public Transfer pocket(String pocket) {
    this.pocket = pocket;
    return this;
  }

  /**
   * Get pocket
   * @return pocket
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPocket() {
    return pocket;
  }

  public void setPocket(String pocket) {
    this.pocket = pocket;
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
    return Objects.equals(this.from, transfer.from) &&
        Objects.equals(this.to, transfer.to) &&
        Objects.equals(this.amount, transfer.amount) &&
        Objects.equals(this.pocket, transfer.pocket) &&
        Objects.equals(this.nonce, transfer.nonce) &&
        Objects.equals(this.v, transfer.v) &&
        Objects.equals(this.r, transfer.r) &&
        Objects.equals(this.s, transfer.s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, amount, pocket, nonce, v, r, s);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transfer {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    pocket: ").append(toIndentedString(pocket)).append("\n");
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
