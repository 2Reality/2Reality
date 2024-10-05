package com.back2reality.network;

/**
 * @author FLIGHT
 */
public record TRResponse(String answer) {

  public static TRResponse of(String answer) {
    return new TRResponse(answer);
  }
}
