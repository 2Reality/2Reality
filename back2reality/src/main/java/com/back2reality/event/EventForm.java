package com.back2reality.event;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public record EventForm(
  String title,
  String description,
  LocalDateTime start,
  LocalDateTime finish) {
}

