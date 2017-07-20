package com.hatorach.tcrs;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.mail.MailService;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.UrlGenerator;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.response.ReservationAddResponse;
import lombok.Builder;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

/**
 * Created by chjtom on 15.07.17.
 */
@Service
@Builder
public class ReservationAdder {
  private ReservationRepository reservationRepository;
  private MailService mailService;
  private UrlGenerator urlGenerator;

  @Autowired
  public ReservationAdder(ReservationRepository reservationRepository, MailService mailService, UrlGenerator urlGenerator) {
    this.reservationRepository = reservationRepository;
    this.mailService = mailService;
    this.urlGenerator = urlGenerator;
  }

  /**
   * Logic for adding a new reservation.
   */
  public ReservationAddResponse add(ReservationAddRequest reservationAddRequest) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    Reservation reservation = modelMapper.map(reservationAddRequest, Reservation.class);
    reservation.setAccessHash(RandomStringUtils.randomAscii(12));
    reservation = reservationRepository.save(reservation);

    this.mailService.send(mailBuilder -> mailBuilder.recipient("office@hatorach.com").subject("TCRS").body("TESTMSG"));

    ReservationAddResponse returner = modelMapper.map(reservation, ReservationAddResponse.class);
    returner.setUrl(urlGenerator.getUrl("reservation/edit/" + reservation.getId() + "/" + reservation.getAccessHash()));
    return returner;
  }
}
