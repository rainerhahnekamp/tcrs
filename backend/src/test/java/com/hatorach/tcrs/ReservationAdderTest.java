package com.hatorach.tcrs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.mail.Mail;
import com.hatorach.tcrs.mail.MailService;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.function.UnaryOperator;

/**
 * Created by chjtom on 15.07.17.
 */
public class ReservationAdderTest {

  @Captor
  private ArgumentCaptor<UnaryOperator<Mail.MailBuilder>> argumentCaptor;


  @Test
  public void testAdd() {
    ReservationRepository reservationRepository = mock(ReservationRepository.class);
    ReservationAddRequest addRequest = new ReservationAddRequest();
    Instant now = Instant.now();
    addRequest.setStartDatetime(now);
    addRequest.setHours(5);
    addRequest.setClubId("utc-st-georgen");
    addRequest.setCourtId("suzanne-langlene");
    ReservationAdder reservationAdder =
      ReservationAdder.builder()
        .reservationRepository(reservationRepository)
        .mailService(mock(MailService.class)).build();
    reservationAdder.add(addRequest);

    ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
    verify(reservationRepository).save(captor.capture());

    Reservation reservation = captor.getValue();
    assertEquals(5, reservation.getHours());
    assertEquals(now, reservation.getStartDatetime());
    assertEquals("utc-st-georgen", reservation.getClubId());
    assertEquals("suzanne-langlene", reservation.getCourtId());
    assertEquals(12, reservation.getAccessHash().length());
  }

  @Test
  public void testMail() {
    MockitoAnnotations.initMocks(this);

    MailService mailService = mock(MailService.class);
    ReservationAdder reservationAdder =
      ReservationAdder.builder()
        .reservationRepository(mock(ReservationRepository.class))
        .mailService(mailService).build();

    reservationAdder.add(new ReservationAddRequest());

    verify(mailService).send(this.argumentCaptor.capture());
    Mail.MailBuilder mailBuilder = Mail.builder();
    this.argumentCaptor.getValue().apply(mailBuilder);
    assertEquals("TESTMSG", mailBuilder.build().getBody());
  }

}
