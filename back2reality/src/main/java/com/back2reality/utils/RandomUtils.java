package com.back2reality.utils;

import java.util.Random;

/**
 * @author FLIGHT
 */
public class RandomUtils {

  private static final int maxStringLength = 16;
  private static final Random random = new Random();

  public static int generateInteger(int bound) {
    return random.nextInt(bound);
  }

  public static double generatePrettyDouble(double bound, int places) {
    return MathUtils.round(random.nextDouble(bound), places);
  }

  public static double generatePrettyDouble(double bound) {
    return MathUtils.round(random.nextDouble(bound), 2);
  }

  private static boolean generateBoolean() {
    return random.nextBoolean();
  }

  public static String generatePrettyRandomString() {
    int length = generateInteger(maxStringLength);
    return generatePrettyRandomString(length);
  }

  public static String generatePrettyRandomString(int length) {
    String generated = generateRandomString(LanguageUtils.ENGLISH_ALPHA_LOWERCASE, length);
    boolean firstLetterUppercase = generateBoolean();
    return firstLetterUppercase ? StringUtils.capitalize(generated) : generated;
  }

  public static String generateRandomString(String candidateChars, int length) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < length; ++i) {
      char nextLetter = candidateChars.charAt(generateInteger(candidateChars.length()));
      result.append(nextLetter);
    }

    return result.toString();
  }
}
