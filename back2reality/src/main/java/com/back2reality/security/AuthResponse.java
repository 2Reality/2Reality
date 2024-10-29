package com.back2reality.security;

import com.back2reality.storage.entities.User;

/**
 * @author FLIGHT
 */
public record AuthResponse(String fullname, String nickname) {

  public static AuthResponse from(User user) {
    return new AuthResponse(
      user.getFullname(),
      user.getUsername()
    );
  }
}
