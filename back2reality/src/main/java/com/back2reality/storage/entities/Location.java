package com.back2reality.storage.entities;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

/**
 * @author FLIGHT
 */

@Entity
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location")
  @SequenceGenerator(name = "location", sequenceName = "s_location", allocationSize = 1)
  private long id;

  private String title;

  @Column(columnDefinition = "geometry(Point, 4326)")
  private Point location;

  public Location() {
  }

  public Location(String title, Point location) {
    this.title = title;
    this.location = location;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Point getLocation() {
    return location;
  }

  public void setLocation(Point location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "Location{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", location=" + location +
      '}';
  }
}
