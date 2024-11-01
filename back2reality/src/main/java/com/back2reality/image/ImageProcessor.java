package com.back2reality.image;

import com.back2reality.storage.dao.HumanStorage;
import com.back2reality.storage.dao.ImageStorage;
import com.back2reality.storage.entities.Human;
import com.back2reality.storage.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @author FLIGHT
 */
public class ImageProcessor {

  private final ImageStorage imageStorage;

  private final HumanStorage humanStorage;

  private final ImageCompressor imageCompressor;

  public ImageProcessor(
    ImageStorage imageStorage,
    HumanStorage humanStorage,
    ImageCompressor imageCompressor)
  {
    this.imageStorage = imageStorage;
    this.humanStorage = humanStorage;
    this.imageCompressor = imageCompressor;
  }

  public void addProfileImage(MultipartFile file, Human human) {
    Optional<Image> newImage = uploadImage(file, human);
//    newImage.ifPresent(image -> {
//      humanStorage.addImage(human, image);
//    });
  }

  public Optional<Image> uploadImage(MultipartFile multipartFile, Human human) {
    if (multipartFile == null || multipartFile.isEmpty())
      return Optional.empty();
    try {
      Image image = new Image();
      image.setName(multipartFile.getOriginalFilename());
      image.setContent(imageCompressor.compressBytes(multipartFile.getBytes()));
      image.setHuman(human);

      return Optional.of(imageStorage.saveImage(image));
    } catch (IOException e) {
      return Optional.empty();
    }
  }
}
