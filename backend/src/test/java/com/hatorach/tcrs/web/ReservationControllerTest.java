package com.hatorach.tcrs.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import com.hatorach.tcrs.web.response.ReservationResponse;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.testng.Assert;

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
    ReservationRepository repository = mock(ReservationRepository.class);
    ReservationController controller = new ReservationController(repository);

    ReservationAddRequest addRequest = new ReservationAddRequest();
    Instant now = Instant.now();
    addRequest.setStartDatetime(now);
    addRequest.setHours(5);
    addRequest.setClubId("utc-st-georgen");
    addRequest.setCourtId("suzanne-langlene");
    controller.add(addRequest);

    ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
    verify(repository).save(captor.capture());

    Reservation reservation = captor.getValue();
    assertEquals(5, reservation.getHours());
    assertEquals(now, reservation.getStartDatetime());
    assertEquals("utc-st-georgen", reservation.getClubId());
    assertEquals("suzanne-langlene", reservation.getCourtId());
  }

  @Test
  public void find() throws Exception {
    Instant now = Instant.now();
    Reservation reservation = new Reservation();
    reservation.setId("someMongoId");
    reservation.setHours(5);
    reservation.setStartDatetime(now);
    List<Reservation> reservations = new ArrayList<>();
    reservations.add(reservation);
    ReservationRepository repository = mock(ReservationRepository.class);
    when(repository.findByStartDatetimeBetween(any(), any()))
      .thenReturn(reservations);

    ReservationController controller = new ReservationController(repository);
    List<ReservationResponse> reservationResponses = controller.find(
      Date.from(now.minus(2, ChronoUnit.DAYS)),
      Date.from(now)
    );

    Assert.assertEquals(1, reservationResponses.size());
    ReservationResponse reservationResponse = reservationResponses.get(0);
    Assert.assertEquals(5, reservationResponse.getHours());
    Assert.assertEquals(now, reservationResponse.getStartDatetime());
    Assert.assertEquals("someMongoId", reservationResponse.getId());
  }
}
