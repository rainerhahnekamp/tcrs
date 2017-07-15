package com.hatorach.tcrs;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ReservationRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chjtom on 15.07.17.
 */
@Service
public class ReservationAdder {
  private ReservationRepository reservationRepository;

  @Autowired
  public ReservationAdder(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public boolean add(ReservationAddRequest reservationAddRequest) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    Reservation reservation = modelMapper.map(reservationAddRequest, Reservation.class);
    reservationRepository.save(reservation);
    return true;
  }
}
