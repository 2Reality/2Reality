package com.back2reality.storage.entities;

import com.back2reality.human.Sex;
import com.back2reality.storage.serialization.JsonToPointDeserializer;
import com.back2reality.storage.serialization.PointToJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

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

  private int age;

  private String geo;

  @JsonSerialize(using = PointToJsonSerializer.class)
  @JsonDeserialize(using = JsonToPointDeserializer.class)
  @Column(columnDefinition = "geometry(Point, 4326)")
  private Point location;

  public Human() {
  }

  public Human(String fullname, String nickname, String description, Sex sex, int age, String geo, Point location) {
    this.fullname = fullname;
    this.nickname = nickname;
    this.description = description;
    this.sex = sex;
    this.age = age;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
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
}
