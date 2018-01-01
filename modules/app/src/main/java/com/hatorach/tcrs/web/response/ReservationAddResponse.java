package com.hatorach.tcrs.web.response;

import java.time.Instant;
import lombok.Data;

/**
 * Created by chjtom on 20.07.17.
 */
@Data
public class ReservationAddResponse {
  private Long clubId;
  private String courtId;
  private int hours;
  private Instant startDatetime;
  private String url;
}
