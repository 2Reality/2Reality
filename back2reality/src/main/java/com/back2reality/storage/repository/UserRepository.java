package com.back2reality.storage.repository;

import com.back2reality.storage.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author FLIGHT
 */
public interface UserRepository extends CrudRepository<User, Long> {

  @Transactional
  Optional<User> findByUsername(String username);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);
}
