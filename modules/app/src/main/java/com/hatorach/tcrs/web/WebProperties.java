package com.hatorach.tcrs.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chjtom on 20.07.17.
 */
@Data
@Configuration
@ConfigurationProperties("web")
public class WebProperties {
  private String baseUrl;
}
