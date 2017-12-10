package com.hatorach.tcrs.security;

import static org.junit.Assert.assertTrue;

import com.hatorach.tcrs.security.registration.PasswordCheck;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by rainerh on 23.06.17.
 */
public class PasswordCheckTest {
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void testNormalPassword() {
    assertTrue(new PasswordCheck().allowPassword("passw0rd", "passw0rd"));
  }

  @Test
  public void testIdenticalPasswords() {
    exception.expectMessage("passwords do not match");
    new PasswordCheck().allowPassword("password", "Password");
  }

  @Test
  public void testEmptyPasswords() {
    exception.expectMessage("password is too short");
    new PasswordCheck().allowPassword("", "");
  }

  @Test
  public void testShortPassword() {
    exception.expectMessage("password is too short");
    new PasswordCheck().allowPassword("pasword", "pasword");
  }

  @Test
  public void testPasswordOnlyNumbers() {
    exception.expectMessage("password does not meet the complexity requirements");
    new PasswordCheck().allowPassword("12345678", "12345678");
  }

  @Test
  public void testPasswordOnlyChars() {
    exception.expectMessage("password does not meet the complexity requirements");
    new PasswordCheck().allowPassword("password", "password");
  }

  @Test
  public void testPasswordSecurity() {
    exception.expectMessage("password does not meet the complexity requirements");
    new PasswordCheck().allowPassword("12345678", "12345678");
  }
}
