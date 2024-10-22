package com.back2reality.location;

import com.back2reality.storage.entities.Location;

/**
 * @author FLIGHT
 */
public class LocationMapper {

    public LocationItem toLocationItem(Location location) {
        return new LocationItem(
                location.getTitle(),
                location.getLocation().getX(),
                location.getLocation().getY()
        );
    }
}
