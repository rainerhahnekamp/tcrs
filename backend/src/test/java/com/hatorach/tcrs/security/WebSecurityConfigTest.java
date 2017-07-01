package com.hatorach.tcrs.security;

import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.Map;

/**
 * Created by rainerh on 12.06.16.
 */
public class WebSecurityConfigTest {
  private WebSecurityConfig config = new WebSecurityConfig();

  /* make sure basic setting methods are called */
  @Test
  public void configure() throws Exception {
    @SuppressWarnings("unchecked")
    Map<Class<? extends Object>, Object> map =
      (Map<Class<? extends Object>, Object>) mock(Map.class);

    @SuppressWarnings("unchecked")
    ObjectPostProcessor<Object> objectPostProcessor =
      (ObjectPostProcessor<Object>) mock(ObjectPostProcessor.class);
    HttpSecurity httpSecurity = new HttpSecurity(
      objectPostProcessor,
      mock(AuthenticationManagerBuilder.class), map);
    config.configure(httpSecurity);
  }

  @Test
  public void timeModule() throws Exception {
    Assert.assertThat(config.timeModule(), IsInstanceOf.instanceOf(JavaTimeModule.class));
  }

}
