package com.back2reality.security;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FLIGHT
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

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
}
