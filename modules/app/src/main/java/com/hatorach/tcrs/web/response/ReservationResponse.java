package com.hatorach.tcrs.web.response;

import lombok.Data;

import java.time.Instant;

/**
 * Created by rainerh on 25.04.16.
 */
@Data
public class ReservationResponse {
  private String id;
  private Instant startDatetime;
  private int hours;
}
