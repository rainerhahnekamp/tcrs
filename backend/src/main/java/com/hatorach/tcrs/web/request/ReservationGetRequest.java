package com.hatorach.tcrs.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

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
  private String clubId;
}
