package com.hatorach.tcrs.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by rainerh on 23.04.17.
 */
@Data
@Builder
public class Club {
  @Id
  private String id;

  private String url;

  private String name;
}
