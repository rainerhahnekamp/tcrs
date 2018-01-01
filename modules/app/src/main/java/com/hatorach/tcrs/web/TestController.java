package com.hatorach.tcrs.web;

import com.hatorach.tcrs.mail.MailService;
import java.util.Optional;
import javax.mail.MessagingException;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rainerh on 03.07.17.
 */
@RestController
@Profile("dev")
@RequestMapping("test")
public class TestController {
  private MailService mailService;

  public TestController(MailService mailService) {
    this.mailService = mailService;
  }

  /**
   * this method allows a user in the dev profile to send an email to a
   * particular address.
   */
  @GetMapping(value = "sendMail")
  public String sendMail(
      final String recipient, Optional<String> body, Optional<String> subject)
      throws MessagingException {
    mailService.send(mailBuilder -> mailBuilder
        .recipient(recipient)
        .body(body.orElse("<h1>This a test mail.</h1>"))
        .subject(subject.orElse("TCRS Testmail")));

    return "finished";
  }
}
