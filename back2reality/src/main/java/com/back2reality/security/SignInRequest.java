package com.back2reality.security;

/**
 * @author FLIGHT
 */
public record SignInRequest(
  String username,
  String password) {
}
