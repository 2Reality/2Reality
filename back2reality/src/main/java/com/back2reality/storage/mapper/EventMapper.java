package com.back2reality.storage.mapper;

import com.back2reality.event.EventForm;
import com.back2reality.event.EventItem;
import com.back2reality.location.LocationFactory;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.entities.Event;
import com.back2reality.utils.MathUtils;
import org.locationtech.jts.geom.Point;

/**
 * @author FLIGHT
 */
public class EventMapper {

    private final LocationFactory locationFactory;

    public EventMapper(LocationFactory locationFactory) {
        this.locationFactory = locationFactory;
    }

    public EventItem toEventItem(Event event, RecommenderContext recommenderContext) {
        double distance = MathUtils.round(event.getLocation().distance(recommenderContext.location()), 2);
        return new EventItem(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getStart(),
                event.getFinish(),
                event.getGeo(),
                distance,
                EventItem.DEFAULT_SCORE
        );
    }

    public Event toEvent(EventForm eventForm) {
        Point point = locationFactory.toPoint(
                eventForm.longitude(),
                eventForm.latitude()
        );

        return new Event(
                eventForm.title(),
                eventForm.description(),
                eventForm.start(),
                eventForm.finish(),
                eventForm.geo(),
                point
        );
    }
}
