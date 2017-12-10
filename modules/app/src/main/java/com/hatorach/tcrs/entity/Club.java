package com.hatorach.tcrs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rainerh on 23.04.17.
 */
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Club {
  @Id
  @GeneratedValue
  private Long id;

  private String url;

  private String name;
}
