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
 * ReservationAddResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-06T22:03:33.269Z")

public class ReservationAddResponse   {
  @JsonProperty("clubId")
  private Long clubId = null;

  @JsonProperty("courtId")
  private String courtId = null;

  @JsonProperty("hours")
  private Integer hours = null;

  @JsonProperty("startDatetime")
  private OffsetDateTime startDatetime = null;

  @JsonProperty("url")
  private String url = null;

  public ReservationAddResponse clubId(Long clubId) {
    this.clubId = clubId;
    return this;
  }

  /**
   * Get clubId
   * @return clubId
  **/
  @ApiModelProperty(value = "")


  public Long getClubId() {
    return clubId;
  }

  public void setClubId(Long clubId) {
    this.clubId = clubId;
  }

  public ReservationAddResponse courtId(String courtId) {
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

  public ReservationAddResponse hours(Integer hours) {
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

  public ReservationAddResponse startDatetime(OffsetDateTime startDatetime) {
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

  public ReservationAddResponse url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservationAddResponse reservationAddResponse = (ReservationAddResponse) o;
    return Objects.equals(this.clubId, reservationAddResponse.clubId) &&
        Objects.equals(this.courtId, reservationAddResponse.courtId) &&
        Objects.equals(this.hours, reservationAddResponse.hours) &&
        Objects.equals(this.startDatetime, reservationAddResponse.startDatetime) &&
        Objects.equals(this.url, reservationAddResponse.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clubId, courtId, hours, startDatetime, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservationAddResponse {\n");
    
    sb.append("    clubId: ").append(toIndentedString(clubId)).append("\n");
    sb.append("    courtId: ").append(toIndentedString(courtId)).append("\n");
    sb.append("    hours: ").append(toIndentedString(hours)).append("\n");
    sb.append("    startDatetime: ").append(toIndentedString(startDatetime)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

