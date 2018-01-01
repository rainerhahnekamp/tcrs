package com.hatorach.tcrs.web.reservation.adder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hatorach.tcrs.entity.Club;
import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.matchers.RegexMatcher;
import com.hatorach.tcrs.repository.ClubRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import java.time.Instant;
import org.junit.Test;

/**
 * Created by chjtom on 12.08.17.
 */
public class ReservationCreatorTest {

  @Test
  public void testCreate() {
    Instant now = Instant.now();
    ReservationAddRequest addRequest = ReservationAddRequest.builder()
        .startDatetime(now).clubUrl("utc-st-georgen")
        .hours(5).courtId("suzanne-langlene")
        .build();
    Club club = Club.builder().name("utc-st-georgen").build();
    ClubRepository repository = mock(ClubRepository.class);
    when(repository.findByUrl("utc-st-georgen")).thenReturn(club);

    Reservation reservation = new ReservationCreator(repository).create(addRequest);

    assertEquals(5, reservation.getHours());
    assertEquals(now, reservation.getStartDatetime());
    assertEquals(club, reservation.getClub());
    assertEquals("suzanne-langlene", reservation.getCourtId());
    assertThat(reservation.getAccessHash(), RegexMatcher.matchesRegex("\\w{20}"));
  }
}

