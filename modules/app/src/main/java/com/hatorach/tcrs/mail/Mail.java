package com.hatorach.tcrs.mail;

import lombok.Builder;
import lombok.Data;

/**
 * Created by rainerh on 03.07.17.
 */
@Builder
@Data
public class Mail {
  private String sender;
  private String recipient;
  private String subject;
  private String body;
}
