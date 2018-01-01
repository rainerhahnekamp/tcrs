package com.hatorach.tcrs.repository;

import com.hatorach.tcrs.entity.Reservation;
import java.time.Instant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rainerh on 24.04.16.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
  List<Reservation> findAll();

  List<Reservation> findByStartDatetimeBetween(Instant from, Instant to);
}
