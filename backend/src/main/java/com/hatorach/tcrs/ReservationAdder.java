package com.hatorach.tcrs;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.mail.MailService;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import lombok.Builder;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chjtom on 15.07.17.
 */
@Service
@Builder
public class ReservationAdder {
  private ReservationRepository reservationRepository;
  private MailService mailService;

  @Autowired
  public ReservationAdder(ReservationRepository reservationRepository, MailService mailService) {
    this.reservationRepository = reservationRepository;
    this.mailService = mailService;
  }

  /**
   * Logic for adding a new reservation.
   */
  public boolean add(ReservationAddRequest reservationAddRequest) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    Reservation reservation = modelMapper.map(reservationAddRequest, Reservation.class);
    reservation.setAccessHash(RandomStringUtils.randomAscii(12));
    reservationRepository.save(reservation);

    this.mailService.send(mailBuilder -> mailBuilder.recipient("office@hatorach.com").subject("TCRS").body("TESTMSG"));

    return true;
  }
}
