package com.hatorach.tcrs.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by rainerh on 25.04.16.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationGetRequest {
  private String id;
  private String hash;
}
