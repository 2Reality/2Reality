package com.back2reality.storage.serialization;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.locationtech.jts.geom.Point;

import java.io.IOException;

/**
 * @author FLIGHT
 */

public class PointToJsonSerializer extends JsonSerializer<Point> {

    @Override
    public void serialize(
            Point value,
            JsonGenerator jsonGenerator,
            SerializerProvider provider) throws IOException {

        String jsonValue = "null";
        try {
            if (value != null) {
                double latitude = value.getY();
                double longitude = value.getX();
                jsonValue = String.format("POINT (%s %s)", latitude, longitude);
            }
        } catch (Exception ignored) {
        }

        jsonGenerator.writeString(jsonValue);
    }
}
