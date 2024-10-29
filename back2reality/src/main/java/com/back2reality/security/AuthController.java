package com.back2reality.security;

import com.back2reality.storage.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * @author FLIGHT
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final Logger logger = LoggerFactory.getLogger(AuthController.class);

  private final AuthenticationService authenticationService;

  public AuthController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("/sign-up")
  public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
    return authenticationService.signUp(request);
  }

  @PostMapping("/sign-in")
  public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
    return authenticationService.signIn(request);
  }

  @GetMapping("/me")
  public AuthResponse checkAuth(@AuthenticationPrincipal User user) {
    logger.info("checking auth status...");
    return AuthResponse.from(user);
  }
}
