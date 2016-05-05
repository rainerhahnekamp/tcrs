package com.hatorach.tcrs.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.response.ReservationResponse;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by rainerh on 24.04.16.
 */
@RestController
@RequestMapping("test")
public class TestController {
  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @RequestMapping("showReservations")
  public List<ReservationResponse> showReservations() {
    return this.reservationRepository
      .findAll()
      .stream()
      .map((reservation) -> new ReservationResponse(reservation))
      .collect(Collectors.toList());
  }

  @RequestMapping("test")
  public LocalDateTime test() throws JsonProcessingException {
    Logger.getLogger(getClass()).info(objectMapper.writeValueAsString(LocalDateTime.now()));
//    Logger.getLogger(getClass()).info(objectMapper.writeValueAsString(LocalDateTime.now()));
    return LocalDateTime.now();
  }
}
