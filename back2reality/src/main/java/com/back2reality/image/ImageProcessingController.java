package com.back2reality.image;

import com.back2reality.network.TRResponse;
import com.back2reality.storage.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author FLIGHT
 */

@RestController
public class ImageProcessingController {

  private final ImageProcessor imageProcessor;

  public ImageProcessingController(ImageProcessor imageProcessor) {
    this.imageProcessor = imageProcessor;
  }

  @PostMapping("/image/add")
  public TRResponse addProfileImage(Authentication authentication,
                                    @RequestParam("image") MultipartFile image)
  {
    User user = (User) authentication.getPrincipal();
    imageProcessor.addProfileImage(image, user.getHuman());
    return TRResponse.of("image successfully added");
  }
}
