package com.back2reality.storage.entities;

import com.back2reality.human.Sex;
import com.back2reality.storage.serialization.JsonToPointDeserializer;
import com.back2reality.storage.serialization.PointToJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author FLIGHT
 */


@Entity
public class Human {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "human")
  @SequenceGenerator(name = "human", sequenceName = "s_human", allocationSize = 1)
  private long id;

  private String fullname;

  private String nickname;

  private String description;

  private Sex sex;

  private LocalDateTime birthDate;

  private String geo;

  @OneToMany(mappedBy = "human", fetch = FetchType.EAGER)
  @JsonIgnoreProperties(value = "human", allowGetters = true)
  private List<Image> images;

  @JsonSerialize(using = PointToJsonSerializer.class)
  @JsonDeserialize(using = JsonToPointDeserializer.class)
  @Column(columnDefinition = "geometry(Point, 4326)")
  private Point location;

  public Human() {
  }

  public Human(String fullname,
               String nickname,
               String description,
               Sex sex,
               LocalDateTime birthDate,
               String geo,
               Point location)
  {
    this.fullname = fullname;
    this.nickname = nickname;
    this.description = description;
    this.sex = sex;
    this.birthDate = birthDate;
    this.geo = geo;
    this.location = location;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public String getGeo() {
    return geo;
  }

  public void setGeo(String geo) {
    this.geo = geo;
  }

  public Point getLocation() {
    return location;
  }

  public void setLocation(Point location) {
    this.location = location;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }
}
