package com.hatorach.tcrs.repository;

import com.hatorach.tcrs.security.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rainerh on 23.06.17.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
