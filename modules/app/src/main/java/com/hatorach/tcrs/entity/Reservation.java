package com.hatorach.tcrs.entity;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Reservation extends AbstractPersistable<Long> {
  @Id
  @GeneratedValue
  private Long id;
  private Instant startDatetime;
  private int hours;
  private String courtId;
  @ManyToOne
  private Club club;
  private String accessHash;
}
