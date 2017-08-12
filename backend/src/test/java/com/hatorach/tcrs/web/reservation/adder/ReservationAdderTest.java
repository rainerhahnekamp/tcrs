package com.hatorach.tcrs.web.reservation.adder;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.mail.MailService;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import org.junit.Test;

/**
 * Created by chjtom on 15.07.17.
 */
public class ReservationAdderTest {
  @Test
  public void doTest() {
    ReservationRepository repository = mock(ReservationRepository.class);
    Reservation reservation = new Reservation();
    when(repository.save(reservation)).thenReturn(reservation);
    ReservationCreator reservationCreator = mock(ReservationCreator.class);
    ReservationAddRequest request = new ReservationAddRequest();
    when(reservationCreator.create(request)).thenReturn(reservation);
    MailService mailService = mock(MailService.class);
    ResponseCreator responseCreator = mock(ResponseCreator.class);
    ReservationAdder adder = new ReservationAdder(
      repository, reservationCreator, responseCreator, mailService);

    adder.add(request);

    verify(repository).save(reservation);
    verify(mailService).send(any());
    verify(responseCreator).create(reservation);
  }
}
