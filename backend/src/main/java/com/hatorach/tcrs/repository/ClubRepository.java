package com.hatorach.tcrs.repository;

import com.hatorach.tcrs.entity.Club;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rainerh on 23.04.17.
 */
public interface ClubRepository extends CrudRepository<Club, String> {
  List<Club> findAll();
}
