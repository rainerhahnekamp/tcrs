package com.hatorach.tcrs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Created by rainerh on 25.05.17.
 */
public class WebConfigTest {
  @Test
  public void testCors() {
    CorsRegistry corsRegistry = mock(CorsRegistry.class);
    new WebConfig().addCorsMappings(corsRegistry);
    verify(corsRegistry).addMapping("/**");
  }
}
