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
 * Information for request green CBDC.
 */
@Schema(description = "Information for request green CBDC.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-13T09:09:20.233Z[GMT]")


public class GreenCBDCRequestInformation   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("lockedUserAmount")
  private BigDecimal lockedUserAmount = null;

  @JsonProperty("requestedAmount")
  private BigDecimal requestedAmount = null;

  @JsonProperty("verifierDocUri")
  private String verifierDocUri = null;

  public GreenCBDCRequestInformation address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public GreenCBDCRequestInformation lockedUserAmount(BigDecimal lockedUserAmount) {
    this.lockedUserAmount = lockedUserAmount;
    return this;
  }

  /**
   * Get lockedUserAmount
   * @return lockedUserAmount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getLockedUserAmount() {
    return lockedUserAmount;
  }

  public void setLockedUserAmount(BigDecimal lockedUserAmount) {
    this.lockedUserAmount = lockedUserAmount;
  }

  public GreenCBDCRequestInformation requestedAmount(BigDecimal requestedAmount) {
    this.requestedAmount = requestedAmount;
    return this;
  }

  /**
   * Get requestedAmount
   * @return requestedAmount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getRequestedAmount() {
    return requestedAmount;
  }

  public void setRequestedAmount(BigDecimal requestedAmount) {
    this.requestedAmount = requestedAmount;
  }

  public GreenCBDCRequestInformation verifierDocUri(String verifierDocUri) {
    this.verifierDocUri = verifierDocUri;
    return this;
  }

  /**
   * Get verifierDocUri
   * @return verifierDocUri
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getVerifierDocUri() {
    return verifierDocUri;
  }

  public void setVerifierDocUri(String verifierDocUri) {
    this.verifierDocUri = verifierDocUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GreenCBDCRequestInformation greenCBDCRequestInformation = (GreenCBDCRequestInformation) o;
    return Objects.equals(this.address, greenCBDCRequestInformation.address) &&
        Objects.equals(this.lockedUserAmount, greenCBDCRequestInformation.lockedUserAmount) &&
        Objects.equals(this.requestedAmount, greenCBDCRequestInformation.requestedAmount) &&
        Objects.equals(this.verifierDocUri, greenCBDCRequestInformation.verifierDocUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, lockedUserAmount, requestedAmount, verifierDocUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GreenCBDCRequestInformation {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    lockedUserAmount: ").append(toIndentedString(lockedUserAmount)).append("\n");
    sb.append("    requestedAmount: ").append(toIndentedString(requestedAmount)).append("\n");
    sb.append("    verifierDocUri: ").append(toIndentedString(verifierDocUri)).append("\n");
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
