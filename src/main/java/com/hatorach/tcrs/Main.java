package com.hatorach.tcrs;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by CHJTOM on 19.03.2016.
 */

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    LoggerFactory.getLogger("tcrs").debug("HELLO WORLD! DAS LOGGED!");
    SpringApplication.run(Main.class);
  }

}
