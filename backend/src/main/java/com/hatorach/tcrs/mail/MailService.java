package com.hatorach.tcrs.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.function.UnaryOperator;
import javax.mail.internet.MimeMessage;

/**
 * Created by rainerh on 03.07.17.
 */
@Service
public class MailService {
  private MailProperties mailProperties;
  private JavaMailSender javaMailSender;

  public MailService(MailProperties mailProperties, JavaMailSender javaMailSender) {
    this.mailProperties = mailProperties;
    this.javaMailSender = javaMailSender;
  }

  /**
   * sends an email by providing a builder object of it in an operator function.
   */
  @Async
  public void send(UnaryOperator<Mail.MailBuilder> builderOperator)
    throws javax.mail.MessagingException {
    Mail mail = builderOperator.apply(getBuilder()).build();

    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
    helper.setFrom(mail.getSender());
    helper.setTo(mail.getRecipient());
    helper.setSubject(mail.getSubject());
    helper.setText(mail.getBody(), true);
    javaMailSender.send(mimeMessage);
  }

  public Mail.MailBuilder getBuilder() {
    return Mail.builder().sender(mailProperties.getDefaultSender());
  }
}
