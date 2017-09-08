package com.hatorach.tcrs.dev;

import com.hatorach.tcrs.entity.Club;
import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ClubRepository;
import com.hatorach.tcrs.repository.ReservationRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by rainerh on 24.04.16.
 *
 * <p>adds fixture for development mode
 */
@Service
public class Fixturizer implements ApplicationListener<ContextRefreshedEvent> {
  private ReservationRepository reservationRepository;
  private ClubRepository clubRepository;

  public Fixturizer(ReservationRepository reservationRepository, ClubRepository clubRepository) {
    this.reservationRepository = reservationRepository;
    this.clubRepository = clubRepository;
  }

  @Override public void onApplicationEvent(ContextRefreshedEvent cre) {
    Instant sunday16 = ZonedDateTime.of(
      LocalDateTime.of(LocalDate.now().with(DayOfWeek.SUNDAY), LocalTime.of(16, 0)),
      ZoneId.of("Europe/Vienna")
    ).toInstant();


    Reservation reservation = Reservation.builder()
      .accessHash("foobar").startDatetime(sunday16).hours(2).build();
    reservationRepository.save(reservation);


    Club tcGeorgeTown = Club.builder().name("TC GeorgeTown").url("tc-georg-town").build();
    Club askoIronCity = Club.builder().name("ASKO IronCity").url("asko-iron-city").build();
    clubRepository.save(tcGeorgeTown);
    clubRepository.save(askoIronCity);
  }

}
