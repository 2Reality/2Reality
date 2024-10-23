package com.back2reality.storage.entities;

import com.back2reality.storage.serialization.JsonToPointDeserializer;
import com.back2reality.storage.serialization.PointToJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

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

    private String geo;

    @JsonSerialize(using = PointToJsonSerializer.class)
    @JsonDeserialize(using = JsonToPointDeserializer.class)
    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point location;

    public Event() {
    }

    public Event(
            String title,
            String description,
            LocalDateTime start,
            LocalDateTime finish,
            String geo,
            Point location)
    {
        this.title = title;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.geo = geo;
        this.location = location;
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
