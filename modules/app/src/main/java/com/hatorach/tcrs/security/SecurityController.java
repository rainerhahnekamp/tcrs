package com.hatorach.tcrs.security;

import com.hatorach.tcrs.security.registration.RegistrationService;
import com.hatorach.tcrs.security.request.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rainerh on 23.06.17.
 */
@RestController
@RequestMapping(name = "security")
public class SecurityController {
  private RegistrationService registrationService;


  /**
   * endpoint for the initial registration with email/password.
   */
  @PostMapping(name = "register")
  public boolean register(@RequestBody RegistrationRequest registrationRequest) {
    registrationService.register(
        registrationRequest.getEmail(), registrationRequest.getPassword(),
        registrationRequest.getPasswordConfirmation());
    return true;
  }
}
