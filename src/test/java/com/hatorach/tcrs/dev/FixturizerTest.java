package com.hatorach.tcrs.dev;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.hatorach.tcrs.entity.Reservation;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by rainerh on 13.06.16.
 */
public class FixturizerTest {
  @Test
  public void onApplicationEvent() throws Exception {
    Fixturizer fixturizer = new Fixturizer();
    MongoTemplate mongoTemplate = mock(MongoTemplate.class);
    fixturizer.setMongoTemplate(mongoTemplate);

    fixturizer.onApplicationEvent(null);
    verify(mongoTemplate, times(3)).save(any(Reservation.class));
  }
}
