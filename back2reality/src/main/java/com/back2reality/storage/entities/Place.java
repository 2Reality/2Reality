package com.back2reality.storage.entities;

import jakarta.persistence.*;

/**
 * @author FLIGHT
 */

@Entity
public class Place {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place")
  @SequenceGenerator(name = "place", sequenceName = "s_place", allocationSize = 1)
  private long id;

  private String title;

  private String description;

  //  temporarily string, will need to be replaced with a specialized data type
  private String geo;

  public Place() {
  }

  public Place(String title, String description, String geo) {
    this.title = title;
    this.description = description;
    this.geo = geo;
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

  public String getGeo() {
    return geo;
  }

  public void setGeo(String geo) {
    this.geo = geo;
  }
}
