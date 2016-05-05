package com.hatorach.tcrs.web.response;

import com.hatorach.tcrs.entity.Reservation;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by rainerh on 25.04.16.
 */
public class ReservationResponse {
  private String id;
  private Instant startDatetime;
  private Long hours;

  public ReservationResponse(Reservation reservation) {
    this.id = reservation.getId();
    this.startDatetime = reservation.getStartDatetime();
    this.hours = reservation.getHours();
  }

  public String getId() {
    return id;
  }

  public Instant getStartDatetime() {
    return startDatetime;
  }

  public Long getHours() {
    return hours;
  }
}
