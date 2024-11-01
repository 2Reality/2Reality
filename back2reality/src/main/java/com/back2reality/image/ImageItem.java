package com.back2reality.image;

/**
 * @author FLIGHT
 */
public record ImageItem(long id, byte[] content) {

  public static ImageItem empty = new ImageItem(0, new byte[]{});
}
