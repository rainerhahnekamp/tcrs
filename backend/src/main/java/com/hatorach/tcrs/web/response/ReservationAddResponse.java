package com.hatorach.tcrs.web.response;

import lombok.Data;

import java.time.Instant;

/**
 * Created by chjtom on 20.07.17.
 */
@Data
public class ReservationAddResponse {
  private String clubId;
  private String courtId;
  private int hours;
  private Instant startDatetime;
  private String url;
}
