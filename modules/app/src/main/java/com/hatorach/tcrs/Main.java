package com.hatorach.tcrs;

import com.hatorach.tcrs.misc.IgnoreInTestCoverage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by CHJTOM on 19.03.2016.
 */

@SpringBootApplication
@IgnoreInTestCoverage
public class Main {
  public static void main(String[] args) {
    String profile = System.getenv().getOrDefault("spring.profiles.active", "dev");
    new SpringApplicationBuilder(Main.class).profiles("dev").run();
  }
}
