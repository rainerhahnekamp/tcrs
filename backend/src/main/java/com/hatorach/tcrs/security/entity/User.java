package com.hatorach.tcrs.security.entity;

import com.hatorach.tcrs.security.registration.RegistrationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rainerh on 23.06.17.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private Long id;

  private String email;
  private String password;
  private String username;
  private RegistrationStatus registrationStatus;
  private boolean regular = true;
  private boolean google = false;
  private boolean facebook = false;
}
