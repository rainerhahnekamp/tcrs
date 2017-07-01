package com.hatorach.tcrs;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;

/**
 * Created by rainerh on 13.06.16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringApplication.class)
public class MainTest {
  @Test
  public void main() throws Exception {
    mockStatic(SpringApplication.class);
    Main.main(null);
    verifyStatic();

    new Main();
  }

}
