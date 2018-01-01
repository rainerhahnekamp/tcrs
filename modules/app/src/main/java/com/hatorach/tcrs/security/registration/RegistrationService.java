package com.hatorach.tcrs.security.registration;

import org.springframework.stereotype.Service;

/**
 * Created by rainerh on 30.06.17.
 */
@Service
public class RegistrationService {
  private PasswordCheck passwordCheck;
  private UserPersister userPersister;
  private UserFinder userFinder;
  private UserCreator userCreator;

  /**
   * constructor.
   */
  public RegistrationService(PasswordCheck passwordCheck, UserPersister userPersister,
                             UserFinder userFinder, UserCreator userCreator) {
    this.passwordCheck = passwordCheck;
    this.userPersister = userPersister;
    this.userFinder = userFinder;
    this.userCreator = userCreator;
  }

  /**
   * main orchestrator method that handles the registration process by email/password.
   */
  public boolean register(String email, String password, String passwordConfirmation) {
    if (!passwordCheck.allowPassword(password, passwordConfirmation)) {
      return false;
    }

    if (userFinder.findByEmail(email).isPresent()) {
      return false;
    }

    userPersister.persist(this.userCreator.create(email, password));

    return true;
  }
}
