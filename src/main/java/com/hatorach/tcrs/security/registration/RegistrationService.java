package com.hatorach.tcrs.security.registration;

import org.springframework.stereotype.Service;

/**
 * Created by rainerh on 30.06.17.
 */
@Service
public class RegistrationService {
  private PasswordCheck passwordCheck;

  public RegistrationService(PasswordCheck passwordCheck) {
    this.passwordCheck = passwordCheck;
  }

  public boolean register(String email, String password, String passwordConfirmation) {
    passwordCheck.allowPassword(password, passwordConfirmation);

    return true;
  }
}
