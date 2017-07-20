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
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;

import java.time.Instant;
import java.util.function.UnaryOperator;

/**
 * Created by chjtom on 15.07.17.
 */
public class ReservationAdderTest {

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
  }

  @Test
  public void testMail() {
    MailService mailService = mock(MailService.class);
    ReservationAdder reservationAdder =
      ReservationAdder.builder()
        .reservationRepository(mock(ReservationRepository.class))
        .mailService(mailService).build();
    ArgumentCaptor<UnaryOperator> captor = ArgumentCaptor.forClass(UnaryOperator.class);

    reservationAdder.add(new ReservationAddRequest());

    verify(mailService).send(captor.capture());
    Mail.MailBuilder mailBuilder = Mail.builder();
    captor.getValue().apply(mailBuilder);
    assertEquals("TESTMSG", mailBuilder.build().getBody());
  }

}
