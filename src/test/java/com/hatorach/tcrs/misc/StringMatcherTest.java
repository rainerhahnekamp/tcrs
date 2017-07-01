package com.hatorach.tcrs.misc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by rainerh on 29.06.17.
 */
public class StringMatcherTest {
  @Test
  public void testPartial() {
    assertTrue(StringMatcher.matches("b", "abc"));
  }

  @Test
  public void constructorTest() {
    new StringMatcher();
  }
}
