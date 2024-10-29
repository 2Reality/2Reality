package com.back2reality.security;

/**
 * @author FLIGHT
 */
public record SignUpRequest(
  String fullname,
  String username,
  String email,
  String password) {
}
