package com.hatorach.tcrs.misc;

import java.util.regex.Pattern;

/**
 * Created by rainerh on 29.06.17.
 *
 * <p>In contrast to the matches method of Pattern this class checks for
 * partial matches.
 */
public class StringMatcher {
  public static boolean matchesPartially(String regex, String string) {
    return Pattern.compile(regex).matcher(string).find();
  }
}
