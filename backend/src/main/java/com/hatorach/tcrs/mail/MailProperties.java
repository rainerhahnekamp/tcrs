package com.hatorach.tcrs.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rainerh on 03.07.17.
 */
@Data
@Configuration
@ConfigurationProperties("mail")
public class MailProperties {
  private String smtpServer;
  private String login;
  private String password;
  private String defaultSender;
}
