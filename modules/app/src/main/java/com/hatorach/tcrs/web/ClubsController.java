package com.hatorach.tcrs.web;

import com.hatorach.tcrs.endpoint.ClubsApi;
import com.hatorach.tcrs.repository.ClubRepository;
import io.swagger.model.ClubsListResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rainerh on 23.04.17.
 */
@Builder
@RestController
public class ClubsController implements ClubsApi {
  private ClubRepository clubRepository;
  private ModelMapper modelMapper;

  public ClubsController(ClubRepository clubRepository, ModelMapper modelMapper) {
    this.clubRepository = clubRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public ResponseEntity<List<ClubsListResponse>> listUsingGET() {
    List<ClubsListResponse> clubs = clubRepository.findAll()
        .stream()
        .map(club -> modelMapper.map(club, ClubsListResponse.class))
        .collect(Collectors.toList());
    return new ResponseEntity<>(clubs, HttpStatus.OK);
  }
}
