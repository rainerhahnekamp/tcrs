package com.hatorach.tcrs;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

/**
 * Created by CHJTOM on 19.03.2016.
 */

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private OAuth2ClientContext oauth2ClientContext;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .antMatcher("/**").authorizeRequests()
      .antMatchers("/", "/login**").permitAll().anyRequest()
      .authenticated().and().exceptionHandling()
      .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
      .logoutSuccessUrl("/").permitAll().and().csrf()
      .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
      .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
  }

  @Bean
  public Module timeModule() {
    return new JavaTimeModule();
  }

  @Bean
  @ConfigurationProperties("facebook.client")
  public AuthorizationCodeResourceDetails facebook() {
    return new AuthorizationCodeResourceDetails();
  }

  @Bean
  @ConfigurationProperties("facebook.resource")
  public ResourceServerProperties facebookResources() {
    return new ResourceServerProperties();
  }

  @Bean
  public FilterRegistrationBean oauth2ClientFilterRegistration(
    OAuth2ClientContextFilter filter) {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(filter);
    registration.setOrder(-100);
    return registration;
  }

  private Filter ssoFilter() {
    OAuth2ClientAuthenticationProcessingFilter facebookFilter =
      new OAuth2ClientAuthenticationProcessingFilter("/login/facebook");
    OAuth2RestTemplate facebookTemplate =
      new OAuth2RestTemplate(facebook(), oauth2ClientContext);
    facebookFilter.setRestTemplate(facebookTemplate);
    UserInfoTokenServices tokenServices = new UserInfoTokenServices(
      facebookResources().getUserInfoUri(), facebook().getClientId());
    tokenServices.setRestTemplate(facebookTemplate);
    facebookFilter.setTokenServices(tokenServices);
    return facebookFilter;
  }
}
