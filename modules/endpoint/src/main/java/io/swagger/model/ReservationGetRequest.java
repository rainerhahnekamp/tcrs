package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationGetRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-06T22:03:33.269Z")

public class ReservationGetRequest   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("hash")
  private String hash = null;

  public ReservationGetRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ReservationGetRequest hash(String hash) {
    this.hash = hash;
    return this;
  }

  /**
   * Get hash
   * @return hash
  **/
  @ApiModelProperty(value = "")


  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationGetRequest reservationGetRequest = (ReservationGetRequest) o;
    return Objects.equals(this.id, reservationGetRequest.id) &&
        Objects.equals(this.hash, reservationGetRequest.hash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationGetRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
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

