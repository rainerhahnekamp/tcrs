package com.hatorach.tcrs.web;

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
    controller.add(addRequest);

    ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
    verify(repository).save(captor.capture());

    Assert.assertEquals(5, captor.getValue().getHours());
    Assert.assertEquals(now, captor.getValue().getStartDatetime());
  }

  @Test
  public void find() throws Exception {
    ReservationRepository repository = mock(ReservationRepository.class);
    ReservationController controller = new ReservationController(repository);


    Instant now = Instant.now();
    List<Reservation> reservations = new ArrayList<>();
    Reservation reservation = new Reservation();
    reservation.setId("someMongoId");
    reservation.setHours(5);
    reservation.setStartDatetime(now);
    reservations.add(reservation);
    when(repository.findByStartDatetimeBetween(any(), any()))
      .thenReturn(reservations);


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
