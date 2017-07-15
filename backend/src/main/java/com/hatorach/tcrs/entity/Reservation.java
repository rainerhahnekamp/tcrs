package com.hatorach.tcrs.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;

/**
 * Created by rainerh on 24.04.16.
 */
@Data
public class Reservation {
  @Id
  private String id;
  private Instant startDatetime;
  private int hours;
  private String courtId;
  private String clubId;
  private String accessHash;
}
