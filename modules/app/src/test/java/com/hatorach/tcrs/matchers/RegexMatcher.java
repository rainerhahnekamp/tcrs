package com.hatorach.tcrs.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by chjtom on 12.08.17.
 */
public class RegexMatcher extends TypeSafeMatcher<String> {

  private final String regex;

  public RegexMatcher(final String regex) {
    this.regex = regex;
  }

  @Override
  public void describeTo(final Description description) {
    description.appendText("matches regex=`" + regex + "`");
  }

  @Override
  public boolean matchesSafely(final String string) {
    return string.matches(regex);
  }


  public static RegexMatcher matchesRegex(final String regex) {
    return new RegexMatcher(regex);
  }
}

