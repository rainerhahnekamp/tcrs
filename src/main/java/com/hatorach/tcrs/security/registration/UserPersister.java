package com.hatorach.tcrs.security.registration;

import com.hatorach.tcrs.security.entity.User;

/**
 * Created by rainerh on 01.07.17.
 */
public interface UserPersister {
  void persist(User user);
}
