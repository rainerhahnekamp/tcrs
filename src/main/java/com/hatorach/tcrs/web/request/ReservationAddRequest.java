package com.hatorach.tcrs.web.request;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by rainerh on 25.04.16.
 */
public class ReservationAddRequest {
  private Instant startDatetime;
  private Long hours;

  public Instant getStartDatetime() {
    return startDatetime;
  }

  public void setStartDatetime(Instant startDatetime) {
    this.startDatetime = startDatetime;
  }

  public Long getHours() {
    return hours;
  }

  public void setHours(Long hours) {
    this.hours = hours;
  }
}
