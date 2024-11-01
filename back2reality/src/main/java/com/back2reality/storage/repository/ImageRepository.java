package com.back2reality.storage.repository;

import com.back2reality.storage.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author FLIGHT
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
