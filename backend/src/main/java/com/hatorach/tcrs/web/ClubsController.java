package com.hatorach.tcrs.web;

import com.hatorach.tcrs.repository.ClubRepository;
import com.hatorach.tcrs.web.response.ClubsListResponse;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rainerh on 23.04.17.
 */
@RestController
@RequestMapping("clubs")
public class ClubsController {
  private ClubRepository clubRepository;
  private ModelMapper modelMapper;

  public ClubsController(ClubRepository clubRepository, ModelMapper modelMapper) {
    this.clubRepository = clubRepository;
    this.modelMapper = modelMapper;
  }

  /**
   * returns all existing clubs.
   */
  @RequestMapping("list")
  public List<ClubsListResponse> list() {
    return clubRepository.findAll().stream()
      .map(club -> modelMapper.map(club, ClubsListResponse.class))
      .collect(Collectors.toList());
  }
}
