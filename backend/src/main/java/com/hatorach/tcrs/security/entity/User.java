package com.hatorach.tcrs.security.entity;

import com.hatorach.tcrs.security.registration.RegistrationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by rainerh on 23.06.17.
 */
@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private String id;

  private String email;
  private String password;
  private String username;
  private RegistrationStatus registrationStatus;
  private boolean regular = true;
  private boolean google = false;
  private boolean facebook = false;
}
