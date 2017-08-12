package com.hatorach.tcrs.web.reservation.adder;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

/**
 * Created by chjtom on 12.08.17.
 */
@Service
public class ReservationCreator {

  /**
   * creates reservation.
   */
  public Reservation create(ReservationAddRequest request) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    Reservation reservation = modelMapper.map(request, Reservation.class);
    reservation.setAccessHash(RandomStringUtils.randomAlphanumeric(20));
    return reservation;
  }
}
