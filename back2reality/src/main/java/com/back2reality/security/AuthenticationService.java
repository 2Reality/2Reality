package com.back2reality.security;

import com.back2reality.storage.entities.Role;
import com.back2reality.storage.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author FLIGHT
 */


public class AuthenticationService {

  private final UserService userService;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public AuthenticationService(
    UserService userService,
    JwtService jwtService,
    PasswordEncoder passwordEncoder,
    AuthenticationManager authenticationManager) {
    this.userService = userService;
    this.jwtService = jwtService;
    this.passwordEncoder = passwordEncoder;
    this.authenticationManager = authenticationManager;
  }

  public JwtAuthenticationResponse signUp(SignUpRequest request) {
    User user = new User();

    user.setFullname(request.fullname());
    user.setUsername(request.username());
    user.setEmail(request.email());
    user.setPassword(passwordEncoder.encode(request.password()));
    user.setRole(Role.USER);

    userService.create(user);

    String jwt = jwtService.generateToken(user);
    return new JwtAuthenticationResponse(jwt);
  }

  public JwtAuthenticationResponse signIn(SignInRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
      request.username(),
      request.password()
    ));

    UserDetails user = userService
      .userDetailsService()
      .loadUserByUsername(request.username());

    String jwt = jwtService.generateToken(user);
    return new JwtAuthenticationResponse(jwt);
  }
}
