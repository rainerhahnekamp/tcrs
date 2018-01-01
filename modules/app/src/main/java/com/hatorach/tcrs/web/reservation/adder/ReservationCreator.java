package com.hatorach.tcrs.web.reservation.adder;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

import com.hatorach.tcrs.entity.Reservation;
import com.hatorach.tcrs.repository.ClubRepository;
import com.hatorach.tcrs.web.request.ReservationAddRequest;
import org.apache.commons.text.RandomStringGenerator;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chjtom on 12.08.17.
 */
@Service
public class ReservationCreator {
  private ClubRepository clubRepository;

  @Autowired
  public ReservationCreator(ClubRepository clubRepository) {
    this.clubRepository = clubRepository;
  }

  /**
   * creates reservation.
   */
  public Reservation create(ReservationAddRequest request) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    Reservation reservation = modelMapper.map(request, Reservation.class);
    reservation.setClub(clubRepository.findByUrl(request.getClubUrl()));
    reservation.setAccessHash(new RandomStringGenerator.Builder()
        .withinRange('0', 'z').filteredBy(LETTERS, DIGITS)
        .build().generate(20));
    return reservation;
  }
}
