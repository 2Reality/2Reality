package com.back2reality.image;

import com.back2reality.storage.dao.ImageStorage;
import com.back2reality.storage.repository.ImageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLIGHT
 */


@Configuration
public class ImageProcessingContextConfiguration {

  @Bean
  public ImageStorage imageStorage(ImageRepository imageRepository) {
    return new ImageStorage(imageRepository);
  }


  @Bean
  public ImageCompressor imageCompressor() {
    return new ImageCompressor();
  }
  @Bean
  public ImageProcessor imageProcessor(
    ImageStorage imageStorage,
    ImageCompressor imageCompressor)
  {
    return new ImageProcessor(
      imageStorage,
      imageCompressor
    );
  }
}
