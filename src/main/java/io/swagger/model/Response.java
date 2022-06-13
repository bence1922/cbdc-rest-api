package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response object contains the response to the request or an error message.
 */
@Schema(description = "Response object contains the response to the request or an error message.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-13T09:09:20.233Z[GMT]")


public class Response   {
  @JsonProperty("response")
  private String response = null;

  public Response response(String response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response response = (Response) o;
    return Objects.equals(this.response, response.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");
    
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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
