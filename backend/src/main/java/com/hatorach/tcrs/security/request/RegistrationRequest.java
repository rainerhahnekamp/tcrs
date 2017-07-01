package com.hatorach.tcrs.security.request;

import lombok.Data;

/**
 * Created by rainerh on 23.06.17.
 */
@Data
public class RegistrationRequest {
  private String email;
  private String password;
  private String passwordConfirmation;
}
