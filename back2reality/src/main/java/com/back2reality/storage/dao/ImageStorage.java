package com.back2reality.storage.dao;

import com.back2reality.storage.entities.Image;
import com.back2reality.storage.repository.ImageRepository;

/**
 * @author FLIGHT
 */
public class ImageStorage {

  private final ImageRepository imageRepository;

  public ImageStorage(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public Image saveImage(Image image) {
    return imageRepository.save(image);
  }
}
