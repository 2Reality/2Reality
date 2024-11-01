package com.back2reality.image;

import com.back2reality.storage.dao.HumanStorage;
import com.back2reality.storage.dao.ImageStorage;
import com.back2reality.storage.repository.ImageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author FLIGHT
 */


@Configuration
public class ImageProcessingContextConfiguration {

  @Bean
  public Deflater deflater() {
    return new Deflater();
  }

  @Bean
  public Inflater inflater() {
    return new Inflater();
  }

  @Bean
  public ImageStorage imageStorage(ImageRepository imageRepository) {
    return new ImageStorage(imageRepository);
  }


  @Bean
  public ImageCompressor imageCompressor(Deflater deflater, Inflater inflater) {
    return new ImageCompressor(deflater, inflater);
  }
  @Bean
  public ImageProcessor imageProcessor(
    ImageStorage imageStorage,
    HumanStorage humanStorage,
    ImageCompressor imageCompressor)
  {
    return new ImageProcessor(
      imageStorage,
      humanStorage,
      imageCompressor
    );
  }
}
