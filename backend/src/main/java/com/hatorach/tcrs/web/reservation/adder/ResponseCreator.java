package com.hatorach.tcrs.web.reservation.adder;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.web.UrlGenerator;
import com.hatorach.tcrs.web.response.ReservationAddResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chjtom on 12.08.17.
 */
@Service
public class ResponseCreator {
  private  UrlGenerator urlGenerator;

  @Autowired
  public ResponseCreator(UrlGenerator urlGenerator) {
    this.urlGenerator = urlGenerator;
  }

  /**
   * creates response.
   */
  public ReservationAddResponse create(Reservation reservation) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    ReservationAddResponse returner = modelMapper.map(reservation, ReservationAddResponse.class);
    returner.setUrl(urlGenerator.getUrl("reservation/edit/" + reservation.getId() + "/"
      + reservation.getAccessHash()));;

    return returner;
  }

}
