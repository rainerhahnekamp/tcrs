package com.hatorach.tcrs.security.registration;

import com.hatorach.tcrs.misc.StringMatcher;
import org.springframework.stereotype.Service;

/**
 * Created by rainerh on 23.06.17.
 */
@Service
public class PasswordCheck {
  public boolean allowPassword(String password, String passwordConfirmation) {
    if (!password.equals(passwordConfirmation)) {
      throw new RuntimeException("passwords do not match");
    }

    if (password.length() < 8) {
      throw new RuntimeException("password is too short");
    }

    boolean hasChar = StringMatcher.matches("[a-zA-Z]", password);
    boolean hasNumber = StringMatcher.matches("[0-9]", password);
    if (!hasChar || !hasNumber) {
      throw new RuntimeException("password does not meet the complexity requirements");
    }

    return true;
  }
}
