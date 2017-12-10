package com.hatorach.tcrs.web;

import com.hatorach.tcrs.mail.MailService;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.request.ReservationGetRequest;
import com.hatorach.tcrs.web.reservation.adder.ReservationAdder;
import com.hatorach.tcrs.web.response.ReservationAddResponse;
import com.hatorach.tcrs.web.response.ReservationDetailResponse;
import com.hatorach.tcrs.web.response.ReservationResponse;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
  private MailService mailService;
  private ReservationRepository reservationRepository;
  private ReservationAdder reservationAdder;

  @Autowired
  public ReservationController(MailService mailService,
                               ReservationRepository reservationRepository,
                               ReservationAdder reservationAdder) {
    this.reservationRepository = reservationRepository;
    this.reservationAdder = reservationAdder;
  }

  /**
   * adds a new reservation.
   */
  @PostMapping(value = "add")
  public ReservationAddResponse add(@RequestBody ReservationAddRequest reservationAddRequest) {
    return this.reservationAdder.add(reservationAddRequest);
  }

  /**
   * get a reservation.
   */
  @PostMapping(value = "get")
  public ReservationDetailResponse get(@RequestBody ReservationGetRequest reservationGetRequest) {
    return null;
  }

  /**
   * remove a reservation.
   */
  @PostMapping(value = "remove")
  public boolean remove(@RequestBody ReservationGetRequest reservationGetRequest) {
    this.mailService.send(
      mailBuilder ->
        mailBuilder
          .subject("Removed Reservation")
          .body("Your reservation has been removed.")
          .recipient("chj.tom@gmail.com")
          .sender("support@hatorach.at")
    );
    return true;
  }

  /**
   * finds reservation for a given period.
   */
  @GetMapping("find/:from/:to")
  public List<ReservationResponse> find(
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to
  ) {
    ModelMapper modelMapper = new ModelMapper();
    return reservationRepository
      .findByStartDatetimeBetween(from.toInstant(), to.toInstant())
      .stream()
      .map(reservation -> modelMapper.map(reservation, ReservationResponse.class))
      .collect(Collectors.toList());
  }
}
