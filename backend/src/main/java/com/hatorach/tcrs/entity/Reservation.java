package com.hatorach.tcrs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

/**
 * Created by rainerh on 24.04.16.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
  @Id
  private String id;
  private Instant startDatetime;
  private int hours;
  private String courtId;
  private String clubId;
  private String accessHash;
}
