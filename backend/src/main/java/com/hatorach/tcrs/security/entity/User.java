package com.hatorach.tcrs.security.entity;

import com.hatorach.tcrs.security.registration.RegistrationStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by rainerh on 23.06.17.
 */
@Document
@Data
public class User {
  @Id
  private String id;

  private String email;
  private String password;
  private String username;
  private RegistrationStatus registrationStatus;
  private boolean isRegular;
  private boolean isGoogle;
  private boolean isFacebook;
}
