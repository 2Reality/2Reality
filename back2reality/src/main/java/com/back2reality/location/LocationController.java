package com.back2reality.location;

import com.back2reality.network.TRResponse;
import com.back2reality.storage.dao.LocationStorage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FLIGHT
 */

@RestController
@RequestMapping("/location")
public class LocationController {

  private final LocationStorage locationStorage;

  public LocationController(LocationStorage locationStorage) {
    this.locationStorage = locationStorage;
  }

  @GetMapping("/near")
  public List<LocationItem> getLocationsNear(
    @RequestParam double longitude,
    @RequestParam double latitude,
    @RequestParam double distance)
  {
    return locationStorage.getLocationsNear(longitude, latitude, distance);
  }

  @PostMapping( "/create")
  public TRResponse create(@RequestBody LocationItem locationForm) {
    locationStorage.saveLocation(locationForm);
    return TRResponse.of("ok");
  }
}
