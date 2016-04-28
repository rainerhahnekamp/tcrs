package com.hatorach.tcrs.repository;

import com.hatorach.tcrs.entity.Reservation;
import org.springframework.data.convert.JodaTimeConverters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Created by rainerh on 24.04.16.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
  List<Reservation> findAll();
  List<Reservation> findByStartDatetimeBetween(Instant from, Instant to);
}
