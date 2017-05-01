package com.hatorach.tcrs.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by rainerh on 01.05.17.
 */
@RestController
public class MainController {
  @RequestMapping("/user")
  public Principal user(Principal principal) {
    return principal;
  }
}
