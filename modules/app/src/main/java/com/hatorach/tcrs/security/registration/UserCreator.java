package com.hatorach.tcrs.security.registration;

import com.hatorach.tcrs.security.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {
  /**
   * Creates a new user when registering with email/password instead via a
   * third-party authenticator.
   **/
  public User create(String email, String password) {
    return User.builder()
        .email(email).password(password).regular(true)
        .registrationStatus(RegistrationStatus.PENDINGACTIVATION)
        .build();
  }
}
