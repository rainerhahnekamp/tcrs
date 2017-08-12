package com.hatorach.tcrs.web.reservation.adder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.matchers.RegexMatcher;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import org.junit.Test;

import java.time.Instant;

/**
 * Created by chjtom on 12.08.17.
 */
public class ReservationCreatorTest {

  @Test
  public void testCreate() {
    Instant now = Instant.now();
    ReservationAddRequest addRequest = ReservationAddRequest.builder().startDatetime(now)
      .clubId("utc-st-georgen").hours(5).courtId("suzanne-langlene").build();

    Reservation reservation = new ReservationCreator().create(addRequest);

    assertEquals(5, reservation.getHours());
    assertEquals(now, reservation.getStartDatetime());
    assertEquals("utc-st-georgen", reservation.getClubId());
    assertEquals("suzanne-langlene", reservation.getCourtId());
    assertThat(reservation.getAccessHash(), RegexMatcher.matchesRegex("\\w{20}"));
  }
}

