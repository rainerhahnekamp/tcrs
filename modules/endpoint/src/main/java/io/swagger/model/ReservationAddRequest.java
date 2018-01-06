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
 * ReservationAddRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-06T22:03:33.269Z")

public class ReservationAddRequest   {
  @JsonProperty("startDatetime")
  private OffsetDateTime startDatetime = null;

  @JsonProperty("hours")
  private Integer hours = null;

  @JsonProperty("courtId")
  private String courtId = null;

  @JsonProperty("clubUrl")
  private String clubUrl = null;

  public ReservationAddRequest startDatetime(OffsetDateTime startDatetime) {
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

  public ReservationAddRequest hours(Integer hours) {
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

  public ReservationAddRequest courtId(String courtId) {
    this.courtId = courtId;
    return this;
  }

  /**
   * Get courtId
   * @return courtId
  **/
  @ApiModelProperty(value = "")


  public String getCourtId() {
    return courtId;
  }

  public void setCourtId(String courtId) {
    this.courtId = courtId;
  }

  public ReservationAddRequest clubUrl(String clubUrl) {
    this.clubUrl = clubUrl;
    return this;
  }

  /**
   * Get clubUrl
   * @return clubUrl
  **/
  @ApiModelProperty(value = "")


  public String getClubUrl() {
    return clubUrl;
  }

  public void setClubUrl(String clubUrl) {
    this.clubUrl = clubUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationAddRequest reservationAddRequest = (ReservationAddRequest) o;
    return Objects.equals(this.startDatetime, reservationAddRequest.startDatetime) &&
        Objects.equals(this.hours, reservationAddRequest.hours) &&
        Objects.equals(this.courtId, reservationAddRequest.courtId) &&
        Objects.equals(this.clubUrl, reservationAddRequest.clubUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDatetime, hours, courtId, clubUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationAddRequest {\n");
    
    sb.append("    startDatetime: ").append(toIndentedString(startDatetime)).append("\n");
    sb.append("    hours: ").append(toIndentedString(hours)).append("\n");
    sb.append("    courtId: ").append(toIndentedString(courtId)).append("\n");
    sb.append("    clubUrl: ").append(toIndentedString(clubUrl)).append("\n");
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

