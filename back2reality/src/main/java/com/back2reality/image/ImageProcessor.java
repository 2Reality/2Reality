package com.back2reality.image;

import com.back2reality.storage.dao.HumanStorage;
import com.back2reality.storage.dao.ImageStorage;
import com.back2reality.storage.entities.Human;
import com.back2reality.storage.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.Deflater;

/**
 * @author FLIGHT
 */
public class ImageProcessor {

  private final ImageStorage imageStorage;

  private final HumanStorage humanStorage;

  private final Deflater deflater;

  public ImageProcessor(ImageStorage imageStorage, HumanStorage humanStorage, Deflater deflater) {
    this.imageStorage = imageStorage;
    this.humanStorage = humanStorage;
    this.deflater = deflater;
  }

  public void addProfileImage(MultipartFile file, Human human) {
    Optional<Image> newImage = uploadImage(file);
    newImage.ifPresent(image -> {
      humanStorage.addImage(human, image);
    });
  }

  public Optional<Image> uploadImage(MultipartFile multipartFile) {
    if (multipartFile == null || multipartFile.isEmpty())
      return Optional.empty();
    try {
      Image image = new Image();
      image.setName(multipartFile.getOriginalFilename());
      image.setContent(compressBytes(multipartFile.getBytes()));

      return Optional.of(imageStorage.saveImage(image));
    } catch (IOException e) {
      return Optional.empty();
    }
  }

  private byte[] compressBytes(byte[] data) {
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

    System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

    return outputStream.toByteArray();
  }
}
