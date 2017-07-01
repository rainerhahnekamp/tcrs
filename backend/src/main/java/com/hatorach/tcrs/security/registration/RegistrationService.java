package com.hatorach.tcrs.security.registration;

import com.hatorach.tcrs.security.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by rainerh on 30.06.17.
 */
@Service
public class RegistrationService {
  private PasswordCheck passwordCheck;
  private UserPersister userPersister;
  private UserFinder userFinder;

  public RegistrationService(PasswordCheck passwordCheck, UserPersister userPersister, UserFinder userFinder) {
    this.passwordCheck = passwordCheck;
    this.userPersister = userPersister;
    this.userFinder = userFinder;
  }

  public boolean register(String email, String password, String passwordConfirmation) {
    if (!passwordCheck.allowPassword(password, passwordConfirmation)) {
      return false;
    }

    if (userFinder.findByEmail(email).isPresent()) {
      return false;
    }

    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    user.setRegistrationStatus(RegistrationStatus.PENDINGACTIVATION);
    userPersister.persist(user);

    return true;
  }
}
