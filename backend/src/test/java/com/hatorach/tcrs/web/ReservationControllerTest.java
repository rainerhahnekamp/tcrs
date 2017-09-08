package com.hatorach.tcrs.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.reservation.adder.ReservationAdder;
import com.hatorach.tcrs.web.response.ReservationResponse;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rainerh on 13.06.16.
 */
public class ReservationControllerTest {
  @Test
  public void add() throws Exception {
    ReservationAdder reservationAdder = mock(ReservationAdder.class);
    ReservationController controller =
      ReservationController.builder().reservationAdder(reservationAdder).build();
    ReservationAddRequest reservationAddRequest = new ReservationAddRequest();

    controller.add(reservationAddRequest);
    verify(reservationAdder).add(reservationAddRequest);
  }

  @Test
  public void find() throws Exception {
    Instant now = Instant.now();
    Reservation reservation = Reservation.builder().hours(5).startDatetime(now).build();
    List<Reservation> reservations = new ArrayList<>();
    reservations.add(reservation);
    ReservationRepository repository = mock(ReservationRepository.class);
    when(repository.findByStartDatetimeBetween(any(), any()))
      .thenReturn(reservations);

    ReservationController controller =
      ReservationController.builder().reservationRepository(repository).build();
    List<ReservationResponse> reservationResponses = controller.find(
      Date.from(now.minus(2, ChronoUnit.DAYS)),
      Date.from(now)
    );

    assertEquals(1, reservationResponses.size());
    ReservationResponse reservationResponse = reservationResponses.get(0);
    assertEquals(5, reservationResponse.getHours());
    assertEquals(now, reservationResponse.getStartDatetime());
  }
}
