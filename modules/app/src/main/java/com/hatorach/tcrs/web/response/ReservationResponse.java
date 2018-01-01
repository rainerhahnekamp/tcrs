package com.hatorach.tcrs.web.response;

import java.time.Instant;
import lombok.Data;

/**
 * Created by rainerh on 25.04.16.
 */
@Data
public class ReservationResponse {
  private String id;
  private Instant startDatetime;
  private int hours;
}
