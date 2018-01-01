package com.hatorach.tcrs.web.reservation.adder;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.mail.MailService;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.response.ReservationAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chjtom on 15.07.17.
 */
@Service
public class ReservationAdder {
  private ReservationRepository reservationRepository;
  private MailService mailService;
  private ReservationCreator reservationCreator;
  private ResponseCreator responseCreator;

  /**
   * Constructor.
   */
  @Autowired
  public ReservationAdder(
      ReservationRepository reservationRepository, ReservationCreator reservationCreator,
      ResponseCreator responseCreator, MailService mailService) {
    this.reservationRepository = reservationRepository;
    this.mailService = mailService;
    this.reservationCreator = reservationCreator;
    this.responseCreator = responseCreator;
  }

  /**
   * Logic for adding a new reservation.
   */
  public ReservationAddResponse add(ReservationAddRequest reservationAddRequest) {
    Reservation reservation = reservationRepository
        .save(reservationCreator.create(reservationAddRequest));

    this.mailService.send(mailBuilder ->
        mailBuilder.recipient("office@hatorach.com").subject("TCRS").body("TESTMSG"));

    return this.responseCreator.create(reservation);
  }
}
