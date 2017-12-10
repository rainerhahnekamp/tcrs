package com.hatorach.tcrs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

import com.hatorach.tcrs.repository.UserRepository;
import com.hatorach.tcrs.security.entity.User;
import org.junit.Test;

/**
 * Created by rainerh on 01.07.17.
 */
public class SecurityConfigTest {
  @Test
  public void getUserFind() throws Exception {
    UserRepository userRepository = mock(UserRepository.class);
    User mrx = new User();
    when(userRepository.findByEmail("foo@bar.com")).thenReturn(mrx);
    assertEquals(
      mrx,
      new SecurityConfig().getUserFind(userRepository).findByEmail("foo@bar.com").get()
    );
  }

  @Test
  public void getUserPersister() throws Exception {
    UserRepository userRepository = mock(UserRepository.class);
    User mrx = new User();
    new SecurityConfig().getUserPersister(userRepository).persist(mrx);
    verify(userRepository).save(mrx);
  }

}
