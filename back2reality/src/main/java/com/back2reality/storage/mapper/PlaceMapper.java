package com.back2reality.storage.mapper;

import com.back2reality.location.LocationFactory;
import com.back2reality.place.PlaceForm;
import com.back2reality.place.PlaceItem;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.entities.Place;
import com.back2reality.utils.MathUtils;
import org.locationtech.jts.geom.Point;

/**
 * @author FLIGHT
 */
public class PlaceMapper {

    private final LocationFactory locationFactory;

    public PlaceMapper(LocationFactory locationFactory) {
        this.locationFactory = locationFactory;
    }

    public PlaceItem toPlaceItem(Place place, RecommenderContext recommenderContext) {
        double distance = MathUtils.round(
                place.getLocation().distance(recommenderContext.location()) * 100, 2
        );

        return new PlaceItem(
                place.getId(),
                place.getTitle(),
                place.getDescription(),
                place.getGeo(),
                distance,
                PlaceItem.DEFAULT_SCORE
        );
    }


    public Place toPlace(PlaceForm placeForm) {
        Point location = locationFactory.toPoint(
                placeForm.longitude(),
                placeForm.latitude()
        );
        return new Place(
                placeForm.title(),
                placeForm.description(),
                placeForm.geo(),
                location
        );
    }
}
