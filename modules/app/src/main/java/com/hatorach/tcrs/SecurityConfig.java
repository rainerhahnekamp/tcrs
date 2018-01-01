package com.hatorach.tcrs;

import com.hatorach.tcrs.repository.UserRepository;
import com.hatorach.tcrs.security.registration.UserFinder;
import com.hatorach.tcrs.security.registration.UserPersister;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rainerh on 01.07.17.
 */
@Configuration
public class SecurityConfig {
  /**
   * returns anonymous wrapper of the MongoDB Repository.
   */
  @Bean
  public UserFinder getUserFind(UserRepository userRepository) {
    return email -> Optional.ofNullable(userRepository.findByEmail(email));
  }

  /**
   * returns anonymous wrapper of the MongoDB Repository.
   */
  @Bean
  public UserPersister getUserPersister(UserRepository userRepository) {
    return userRepository::save;
  }
}
