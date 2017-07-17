package com.hatorach.tcrs;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

/**
 * Created by chjtom on 15.07.17.
 */
public class ReservationAdderTest {

  @Test
  public void testAdd() {
    ReservationRepository reservationRepository = mock(ReservationRepository.class);
    ReservationAdder reservationAdder =
      ReservationAdder.builder().reservationRepository(reservationRepository).build();
    ReservationAddRequest addRequest = new ReservationAddRequest();
    Instant now = Instant.now();
    addRequest.setStartDatetime(now);
    addRequest.setHours(5);
    addRequest.setClubId("utc-st-georgen");
    addRequest.setCourtId("suzanne-langlene");
    reservationAdder.add(addRequest);

    ArgumentCaptor<Reservation> captor = ArgumentCaptor.forClass(Reservation.class);
    verify(reservationRepository).save(captor.capture());

    Reservation reservation = captor.getValue();
    assertEquals(5, reservation.getHours());
    assertEquals(now, reservation.getStartDatetime());
    assertEquals("utc-st-georgen", reservation.getClubId());
    assertEquals("suzanne-langlene", reservation.getCourtId());
  }
}
