package com.hatorach.tcrs.web.request;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by rainerh on 25.04.16.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationAddRequest {
  private Instant startDatetime;
  private int hours;
  private String courtId;
  private String clubUrl;
}
