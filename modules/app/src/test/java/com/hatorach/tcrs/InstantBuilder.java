package com.hatorach.tcrs;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by chjtom on 20.07.17.
 */
public class InstantBuilder {
  public static Instant fromDate(String date) {
    LocalDate localDate = LocalDate.parse(date);
    return localDate.atStartOfDay(ZoneId.of("Europe/Vienna")).toInstant();
  }
}
