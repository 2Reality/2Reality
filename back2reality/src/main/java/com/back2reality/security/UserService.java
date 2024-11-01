package com.back2reality.security;

import com.back2reality.storage.entities.Role;
import com.back2reality.storage.entities.User;
import com.back2reality.storage.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author FLIGHT
 */
public class UserService {

  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }


  public User save(User user) {
    return repository.save(user);
  }


  public User create(User user) {
    if (repository.existsByUsername(user.getUsername())) {
      throw new RuntimeException("User with this username already exists");
    }

//    if (repository.existsByEmail(user.getEmail())) {
//      throw new RuntimeException("A user with this email already exists");
//    }

    return save(user);
  }


  public User getByUsername(String username) {
    return repository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }


  public UserDetailsService userDetailsService() {
    return this::getByUsername;
  }

  public User getCurrentUser() {
    var username = SecurityContextHolder.getContext().getAuthentication().getName();
    return getByUsername(username);
  }


  @Deprecated
  public void getAdmin() {
    var user = getCurrentUser();
    user.setRole(Role.ADMIN);
    save(user);
  }
}
