package com.back2reality.storage.repository;

import com.back2reality.storage.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author FLIGHT
 */
public interface HumanRepository extends JpaRepository<Human, Long> {
  @Query("SELECT h " +
    "       FROM Human h" +
    "       LEFT JOIN FETCH h.images" +
    "      WHERE h.nickname =:nickname")
  Optional<Human> findHumanByNickname(String nickname);

  @Query("SELECT h " +
    "       FROM Human h" +
    "       LEFT JOIN FETCH h.images")
  Iterable<Human> findAllWithImages();
}
