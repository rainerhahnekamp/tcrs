package com.hatorach.tcrs.web;

import static org.testng.AssertJUnit.assertEquals;

import org.junit.Test;


/**
 * Created by chjtom on 20.07.17.
 */
public class UrlGeneratorTest {
  @Test
  public void testNormal() {
    WebProperties webProperties = new WebProperties();
    webProperties.setBaseUrl("http://anywhere/");
    UrlGenerator urlGenerator = new UrlGenerator(webProperties);
    assertEquals("http://anywhere/foo/bar", urlGenerator.getUrl("foo/bar"));
  }
}
