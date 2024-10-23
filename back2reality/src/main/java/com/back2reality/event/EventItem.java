package com.back2reality.event;

import com.back2reality.recommender.item.WithDistance;
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
  double distance,
  double score)

  implements WithScore, WithDistance {

  @Override
  public String toString() {
    return "EventItem{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", start=" + start +
            ", finish=" + finish +
            ", geo='" + geo + '\'' +
            ", distance=" + distance +
            ", score=" + score +
            '}';
  }
}
