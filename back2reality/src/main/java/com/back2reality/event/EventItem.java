package com.back2reality.event;

import com.back2reality.recommender.item.WithScore;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public record EventItem(
  long id,
  String title,
  String description,
  LocalDateTime start,
  LocalDateTime finish,
  String geo,
  double score)
  implements WithScore {

  public EventItem(
    long id,
    String title,
    String description,
    LocalDateTime start,
    LocalDateTime finish,
    String geo) {
    this(id, title, description, start, finish, geo, DEFAULT_SCORE);
  }

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