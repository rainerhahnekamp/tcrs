package com.hatorach.tcrs.security.registration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import com.hatorach.tcrs.security.entity.User;
import org.junit.Test;

public class UserCreatorTest {
  @Test
  public void createUser() {
    User user = new UserCreator().create("foo@bar.com", "foobar");
    assertThat(user, allOf(
      hasProperty("email", is("foo@bar.com")),
      hasProperty("password", is("foobar")),
      hasProperty("regular", is(true)),
      hasProperty("facebook", is(false)),
      hasProperty("google", is(false)),
      hasProperty("registrationStatus", is(RegistrationStatus.PENDINGACTIVATION))
    ));
  }
}
