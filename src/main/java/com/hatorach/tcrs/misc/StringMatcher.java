package com.hatorach.tcrs.misc;

import java.util.regex.Pattern;

/**
 * Created by rainerh on 29.06.17.
 *
 * In contrast to the matches method of Pattern this class checks for
 * partial matches.
 */
public class StringMatcher {
  public static boolean matches(String regex, String string) {
    return Pattern.compile(regex).matcher(string).find();
  }
}
