package com.hatorach.tcrs.security.registration;

import com.hatorach.tcrs.security.entity.User;
import java.util.Optional;

/**
 * Created by rainerh on 01.07.17.
 */
public interface UserFinder {
  Optional<User> findByEmail(String email);
}
