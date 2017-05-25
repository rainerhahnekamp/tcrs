package com.hatorach.tcrs;

import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.ApplicationContext;

/**
 * Created by CHJTOM on 19.03.2016.
 */

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class);
  }

}
