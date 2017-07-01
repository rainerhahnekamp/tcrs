package com.hatorach.tcrs;

import com.hatorach.tcrs.repository.UserRepository;
import com.hatorach.tcrs.security.entity.User;
import com.hatorach.tcrs.security.registration.UserFinder;
import com.hatorach.tcrs.security.registration.UserPersister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * Created by rainerh on 01.07.17.
 */
@Configuration
public class SecurityConfig {
  @Bean
  public UserFinder getUserFind(UserRepository userRepository) {
    return new UserFinder() {
      @Override
      public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
      }
    };
  }

  @Bean
  public UserPersister getUserPersister(UserRepository userRepository) {
    return new UserPersister() {
      @Override
      public void persist(User user) {
        userRepository.save(user);
      }
    };
  }
}
