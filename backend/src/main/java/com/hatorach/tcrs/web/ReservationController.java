package com.hatorach.tcrs.web;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.response.ReservationResponse;
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
@RestController
@RequestMapping("reservation")
public class ReservationController {
  private ReservationRepository reservationRepository;

  @Autowired
  public ReservationController(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  /**
   * adds a new reservation.
   */
  @RequestMapping(value = "add", method = RequestMethod.POST)
  public Boolean add(@RequestBody ReservationAddRequest reservationAddRequest) {
    Reservation reservation = new Reservation();
    reservation.setStartDatetime(reservationAddRequest.getStartDatetime());
    reservation.setHours(reservationAddRequest.getHours());
    reservationRepository.save(reservation);
    return true;
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
