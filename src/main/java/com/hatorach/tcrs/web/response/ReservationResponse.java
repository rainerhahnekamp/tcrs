package com.hatorach.tcrs.web.response;

import com.hatorach.tcrs.entity.Reservation;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by rainerh on 25.04.16.
 */
@Data
public class ReservationResponse {
  private String id;
  private Instant startDatetime;
  private int hours;

  public ReservationResponse(Reservation reservation) {
    this.id = reservation.getId();
    this.startDatetime = reservation.getStartDatetime();
    this.hours = reservation.getHours();
  }
}
