package com.hatorach.tcrs.web.request;

import lombok.Data;

import java.time.Instant;

/**
 * Created by rainerh on 25.04.16.
 */
@Data
public class ReservationAddRequest {
  private Instant startDatetime;
  private int hours;
}
