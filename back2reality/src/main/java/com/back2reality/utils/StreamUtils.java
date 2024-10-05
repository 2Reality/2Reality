package com.back2reality.utils;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author FLIGHT
 */
public class StreamUtils {

  public static <T> Stream<T> toStream(Iterable<T> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
  }
}
