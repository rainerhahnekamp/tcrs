package com.hatorach.tcrs.web;

import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.reservation.adder.ReservationAdder;
import com.hatorach.tcrs.web.response.ReservationAddResponse;
import com.hatorach.tcrs.web.response.ReservationResponse;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rainerh on 24.04.16.
 */
@Builder
@RestController
@RequestMapping("reservation")
public class ReservationController {
  private ReservationRepository reservationRepository;
  private ReservationAdder reservationAdder;

  @Autowired
  public ReservationController(ReservationRepository reservationRepository,
                               ReservationAdder reservationAdder) {
    this.reservationRepository = reservationRepository;
    this.reservationAdder = reservationAdder;
  }

  /**
   * adds a new reservation.
   */
  @RequestMapping(value = "add", method = RequestMethod.POST)
  public ReservationAddResponse add(@RequestBody ReservationAddRequest reservationAddRequest) {
    return this.reservationAdder.add(reservationAddRequest);
  }

  /**
   * finds reservation for a given period.
   */
  @RequestMapping("find")
  public List<ReservationResponse> find(
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
  ) {
    ModelMapper modelMapper = new ModelMapper();
    return reservationRepository
      .findByStartDatetimeBetween(from.toInstant(), to.toInstant())
      .stream()
      .map(reservation -> modelMapper.map(reservation, ReservationResponse.class))
      .collect(Collectors.toList());
  }
}
