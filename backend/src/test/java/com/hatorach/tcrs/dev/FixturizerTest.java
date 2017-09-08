package com.hatorach.tcrs.dev;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.hatorach.tcrs.entity.Club;
import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ClubRepository;
import com.hatorach.tcrs.repository.ReservationRepository;
import org.junit.Test;

/**
 * Created by rainerh on 13.06.16.
 */
public class FixturizerTest {
  @Test
  public void onApplicationEvent() throws Exception {
    ReservationRepository reservationRepository = mock(ReservationRepository.class);
    ClubRepository clubRepository = mock(ClubRepository.class);

    Fixturizer fixturizer = new Fixturizer(reservationRepository, clubRepository);

    fixturizer.onApplicationEvent(null);
    verify(reservationRepository).save(any(Reservation.class));
    verify(clubRepository, times(2)).save(any(Club.class));
  }
}
