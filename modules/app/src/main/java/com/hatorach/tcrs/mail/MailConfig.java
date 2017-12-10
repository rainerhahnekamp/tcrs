package com.hatorach.tcrs.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by rainerh on 03.07.17.
 */
@Configuration
public class MailConfig {
  /**
   * Implementation of the sender object that is configured according to
   * the values of application configuration file.
   */
  @Bean
  public JavaMailSender getJavaMailSender(MailProperties mailProperties) {
    JavaMailSenderImpl returner = new JavaMailSenderImpl();
    returner.setHost(mailProperties.getSmtpServer());
    returner.setUsername(mailProperties.getLogin());
    returner.setPassword(mailProperties.getPassword());
    return returner;
  }
}
