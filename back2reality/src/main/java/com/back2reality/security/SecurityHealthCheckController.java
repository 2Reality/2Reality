package com.back2reality.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FLIGHT
 */

@RestController
@RequestMapping("security")
public class SecurityHealthCheckController {

  @GetMapping("/free")
  public String free() {
    return "free";
  }

  @GetMapping("/member")
  @PreAuthorize("hasAnyRole('ADMIN', 'OWNER', 'USER')")
  public String member() {
    return "member";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasAnyRole('OWNER', 'ADMIN')")
  public String admin() {
    return "admin";
  }
}
