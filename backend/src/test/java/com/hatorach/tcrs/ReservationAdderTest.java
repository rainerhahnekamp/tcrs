package com.hatorach.tcrs;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.mail.Mail;
import com.hatorach.tcrs.mail.MailService;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.UrlGenerator;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.response.ReservationAddResponse;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.function.UnaryOperator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

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
        .urlGenerator(mock(UrlGenerator.class))
        .mailService(mock(MailService.class)).build();
    when(reservationRepository.save(any(Reservation.class))).thenReturn(new Reservation());

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
    ReservationRepository repository = mock(ReservationRepository.class);
    ReservationAdder reservationAdder =
      ReservationAdder.builder()
        .reservationRepository(repository)
        .urlGenerator(mock(UrlGenerator.class))
        .mailService(mailService).build();
    when(repository.save(any(Reservation.class))).thenReturn(new Reservation());

    reservationAdder.add(new ReservationAddRequest());

    verify(mailService).send(this.argumentCaptor.capture());
    Mail.MailBuilder mailBuilder = Mail.builder();
    this.argumentCaptor.getValue().apply(mailBuilder);
    assertEquals("TESTMSG", mailBuilder.build().getBody());
  }

  @Test
  public void testUrlGenerator() {
    UrlGenerator urlGenerator = mock(UrlGenerator.class);
    ReservationRepository reservationRepository = mock(ReservationRepository.class);
    ReservationAdder reservationAdder =
      ReservationAdder.builder()
        .reservationRepository(reservationRepository).urlGenerator(urlGenerator)
        .mailService(mock(MailService.class)).build();
    ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
    Instant now = Instant.now();
    Reservation reservation = Reservation.builder().id("foo")
      .accessHash("bar").clubId("tc-stgeorgen")
      .courtId("susanne").hours(2).startDatetime(now).build();
    when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);
    when(urlGenerator.getUrl("reservation/edit/foo/bar")).thenReturn("a");

    ReservationAddResponse reservationAddResponse = reservationAdder
      .add(new ReservationAddRequest());

    assertEquals("a", reservationAddResponse.getUrl());
    assertEquals("tc-stgeorgen", reservationAddResponse.getClubId());
    assertEquals("susanne", reservationAddResponse.getCourtId());
    assertEquals( 2, reservationAddResponse.getHours());
    assertEquals(now, reservationAddResponse.getStartDatetime());
  }

}
