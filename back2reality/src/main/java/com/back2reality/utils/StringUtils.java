package com.back2reality.utils;

/**
 * @author FLIGHT
 */
public class StringUtils {

  public static String capitalize(String string) {
    if (string.isEmpty())
      return string;

    if (string.length() == 1)
      return Character.toUpperCase(string.charAt(0)) + "";

    return Character.toUpperCase(string.charAt(0)) + string.substring(1);
  }
}
