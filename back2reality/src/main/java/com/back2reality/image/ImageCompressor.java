package com.back2reality.image;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author FLIGHT
 */
public class ImageCompressor {

  private final Deflater deflater;

  private final Inflater inflater;

  public ImageCompressor(Deflater deflater, Inflater inflater) {
    this.deflater = deflater;
    this.inflater = inflater;
  }

  public byte[] compressBytes(byte[] data) {
    deflater.setInput(data);
    deflater.finish();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!deflater.finished()) {
      int count = deflater.deflate(buffer);
      outputStream.write(buffer, 0, count);
    }
    try {
      outputStream.close();
    } catch (IOException e) {
      //
    }

    return outputStream.toByteArray();
  }

  public byte[] decompressBytes(byte[] data) {
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    try {
      while (!inflater.finished()) {
        int count = inflater.inflate(buffer);
        outputStream.write(buffer, 0, count);
      }
      outputStream.close();
    } catch (IOException | DataFormatException ioe) {
      //
    }
    return outputStream.toByteArray();
  }
}
