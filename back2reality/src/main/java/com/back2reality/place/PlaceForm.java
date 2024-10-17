package com.back2reality.place;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public record PlaceForm(
  String title,
  String description,
  LocalDateTime start,
  LocalDateTime finish,
  String geo) {
}

