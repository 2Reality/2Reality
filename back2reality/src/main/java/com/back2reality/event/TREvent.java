package com.back2reality.event;

import com.back2reality.recommender.item.WithScore;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public record TREvent(
  long id,
  String title,
  String description,
  LocalDateTime start,
  LocalDateTime finish,
  double score)
  implements WithScore {

  public TREvent(
    long id,
    String title,
    String description) {
    this(id, title, description, LocalDateTime.now(), LocalDateTime.now(), DEFAULT_SCORE);
  }

  public static double DEFAULT_SCORE = 0.0;

  @Override
  public String toString() {
    return "TREvent{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", description='" + description + '\'' +
      ", start=" + start +
      ", finish=" + finish +
      ", score=" + score +
      '}';
  }
}
