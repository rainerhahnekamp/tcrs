package com.hatorach.tcrs.entity;

import org.springframework.data.annotation.Id;

import java.time.Instant;

/**
 * Created by rainerh on 24.04.16.
 */
public class Reservation {
  @Id
  private String id;
  private Instant startDatetime;
  private Long hours;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Instant getStartDatetime() {
    return startDatetime;
  }

  public void setStartDatetime(Instant startDatetime) {
    this.startDatetime = startDatetime;
  }

  public Long getHours() {
    return hours;
  }

  public void setHours(Long hours) {
    this.hours = hours;
  }
}
