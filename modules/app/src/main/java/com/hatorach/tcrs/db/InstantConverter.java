package com.hatorach.tcrs.db;

import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by rainerh on 04.04.16.
 */
@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(Instant instant) {
    return (instant == null ? null : new Timestamp(instant.toEpochMilli()));
  }

  @Override
  public Instant convertToEntityAttribute(Timestamp sqlDate) {
    if (sqlDate == null) {
      return null;
    } else {
      return Instant.ofEpochMilli(sqlDate.getTime());
    }
  }
}
