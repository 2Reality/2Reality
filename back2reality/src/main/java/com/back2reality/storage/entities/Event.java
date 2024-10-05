package com.back2reality.storage.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */

@Entity
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event")
  @SequenceGenerator(name = "event", sequenceName = "s_event", allocationSize = 1)
  private long id;

  private String title;

  private String description;

  private LocalDateTime start;

  private LocalDateTime finish;

  public Event() {}

  public Event(String title, String description, LocalDateTime start, LocalDateTime finish) {
    this.title = title;
    this.description = description;
    this.start = start;
    this.finish = finish;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getStart() {
    return start;
  }

  public void setStart(LocalDateTime start) {
    this.start = start;
  }

  public LocalDateTime getFinish() {
    return finish;
  }

  public void setFinish(LocalDateTime finish) {
    this.finish = finish;
  }
}