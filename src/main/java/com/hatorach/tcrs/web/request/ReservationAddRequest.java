package com.hatorach.tcrs.web.request;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by rainerh on 25.04.16.
 */
public class ReservationAddRequest {
  private Instant startDatetime;
  private int hours;

  public Instant getStartDatetime() {
    return startDatetime;
  }

  public void setStartDatetime(Instant startDatetime) {
    this.startDatetime = startDatetime;
  }

  public int getHours() {
    return hours;
  }

  public void setHours(int hours) {
    this.hours = hours;
  }
}
