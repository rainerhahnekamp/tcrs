package com.hatorach.tcrs.security.registration;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import com.hatorach.tcrs.security.entity.User;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by rainerh on 01.07.17.
 */
public class RegistrationServiceTest {
  @Test
  public void testGeneral() {
    UserFinder finder = mock(UserFinder.class);
    when(finder.findByEmail("somebody@host.com")).thenReturn(Optional.empty());
    PasswordCheck check = mock(PasswordCheck.class);
    when(check.allowPassword(any(), any())).thenReturn(true);
    UserPersister persister = mock(UserPersister.class);
    User user = new User();
    UserCreator creator = mock(UserCreator.class);
    when(creator.create(any(), any())).thenReturn(user);

    new RegistrationService(check, persister, finder, creator)
      .register("somebody@host.com",  "", "");

    verify(check).allowPassword("","");
    verify(creator).create(any(), any());
    verify(persister).persist(user);
  }
}
