package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ReservationResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-06T22:03:33.269Z")

public class ReservationResponse   {
  @JsonProperty("hours")
  private Integer hours = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("startDatetime")
  private OffsetDateTime startDatetime = null;

  public ReservationResponse hours(Integer hours) {
    this.hours = hours;
    return this;
  }

  /**
   * Get hours
   * @return hours
  **/
  @ApiModelProperty(value = "")


  public Integer getHours() {
    return hours;
  }

  public void setHours(Integer hours) {
    this.hours = hours;
  }

  public ReservationResponse id(String id) {
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

  public ReservationResponse startDatetime(OffsetDateTime startDatetime) {
    this.startDatetime = startDatetime;
    return this;
  }

  /**
   * Get startDatetime
   * @return startDatetime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getStartDatetime() {
    return startDatetime;
  }

  public void setStartDatetime(OffsetDateTime startDatetime) {
    this.startDatetime = startDatetime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationResponse reservationResponse = (ReservationResponse) o;
    return Objects.equals(this.hours, reservationResponse.hours) &&
        Objects.equals(this.id, reservationResponse.id) &&
        Objects.equals(this.startDatetime, reservationResponse.startDatetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hours, id, startDatetime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationResponse {\n");
    
    sb.append("    hours: ").append(toIndentedString(hours)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    startDatetime: ").append(toIndentedString(startDatetime)).append("\n");
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

