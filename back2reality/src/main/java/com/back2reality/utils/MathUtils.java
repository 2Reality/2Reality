package com.back2reality.utils;

/**
 * @author FLIGHT
 */
public class MathUtils {

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    return (double) Math.round(value * factor) / factor;
  }
}
