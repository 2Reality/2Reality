package com.back2reality.image;

import com.back2reality.storage.dao.ImageStorage;
import com.back2reality.storage.entities.Human;
import com.back2reality.storage.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author FLIGHT
 */
public class ImageProcessor {

  private final ImageStorage imageStorage;

  private final ImageCompressor imageCompressor;

  public ImageProcessor(
    ImageStorage imageStorage,
    ImageCompressor imageCompressor) {
    this.imageStorage = imageStorage;
    this.imageCompressor = imageCompressor;
  }

  public void addProfileImage(MultipartFile file, Human human) {
    uploadImage(file, human);
  }

  public void uploadImage(MultipartFile multipartFile, Human human) {
    if (multipartFile == null || multipartFile.isEmpty())
      return;
    try {
      Image image = new Image();
      image.setName(multipartFile.getOriginalFilename());
      image.setContent(imageCompressor.compressBytes(multipartFile.getBytes()));
      image.setHuman(human);

      imageStorage.saveImage(image);
    } catch (IOException ignored) {

    }
  }
}
