package com.hatorach.tcrs.web.reservation.adder;

import static org.junit.Assert.assertEquals;

import com.hatorach.tcrs.entity.Club;
import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.web.UrlGenerator;
import com.hatorach.tcrs.web.WebProperties;
import com.hatorach.tcrs.web.response.ReservationAddResponse;
import org.junit.Test;

import java.time.Instant;

/**
 * Created by chjtom on 12.08.17.
 */
public class ResponseCreatorTest {

  @Test
  public void testCreate() {
    WebProperties properties = new WebProperties();
    properties.setBaseUrl("http://www.tcrs.com/");
    UrlGenerator urlGenerator = new UrlGenerator(properties);
    Club stGeorgen = Club.builder().build();
    stGeorgen.setId(1L);


    Instant now = Instant.now();
    Reservation reservation = Reservation.builder().courtId("suzanne-langlene")
      .club(stGeorgen).hours(5).startDatetime(now).accessHash("TESTHASH").build();

    ResponseCreator creator = new ResponseCreator(urlGenerator);
    ReservationAddResponse response = creator.create(reservation);

    assertEquals("http://www.tcrs.com/reservation/edit/null/TESTHASH", response.getUrl());
    assertEquals("suzanne-langlene", response.getCourtId());
    assertEquals(new Long(1L), response.getClubId());
    assertEquals(now, response.getStartDatetime());
    assertEquals(5, response.getHours());
  }
}
