package com.hatorach.tcrs.repository;

import com.hatorach.tcrs.entity.Club;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rainerh on 23.04.17.
 */
public interface ClubRepository extends CrudRepository<Club, Long> {
  List<Club> findAll();

  Club findByUrl(String url);
}
