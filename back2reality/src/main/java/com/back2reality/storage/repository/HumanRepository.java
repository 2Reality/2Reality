package com.back2reality.storage.repository;

import com.back2reality.storage.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author FLIGHT
 */
public interface HumanRepository extends JpaRepository<Human, Long> {
  Optional<Human> findHumanByNickname(String nickname);

}
