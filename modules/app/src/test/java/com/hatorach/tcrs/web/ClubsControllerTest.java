package com.hatorach.tcrs.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hatorach.tcrs.entity.Club;
import com.hatorach.tcrs.repository.ClubRepository;
import com.hatorach.tcrs.web.response.ClubsListResponse;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.modelmapper.ModelMapper;

/**
 * Created by rainerh on 23.04.17.
 */
public class ClubsControllerTest {
  @Test
  public void testList() {
    ModelMapper modelMapper = new ModelMapper();
    Club club1 = Club.builder().name("Club 1").url("club-1").build();
    Club club2 = Club.builder().name("Club 2").url("club-2").build();

    ClubRepository clubRepository = mock(ClubRepository.class);
    when(clubRepository.findAll()).thenReturn(Arrays.asList(club1, club2));

    List<ClubsListResponse> clubs = ClubsController
        .builder()
        .clubRepository(clubRepository).modelMapper(modelMapper)
        .build().list();
    assertEquals("Club 1", clubs.get(0).getName());
    assertEquals("club-1", clubs.get(0).getUrl());
    assertEquals("Club 2", clubs.get(1).getName());
    assertEquals("club-2", clubs.get(1).getUrl());
  }

}
