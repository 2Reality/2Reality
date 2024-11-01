package com.back2reality.storage.repository;

import com.back2reality.storage.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author FLIGHT
 */
public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUsername(String username);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);
}
