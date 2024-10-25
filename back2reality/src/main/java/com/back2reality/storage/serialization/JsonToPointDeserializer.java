package com.back2reality.storage.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;


/**
 * @author FLIGHT
 */
public class JsonToPointDeserializer extends JsonDeserializer<Point> {

    private final static GeometryFactory geometryFactory = new GeometryFactory();

    @Override
    public Point deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {

        try {
            String text = jsonParser.getText();
            if (text == null || text.isEmpty())
                return null;

            String[] coordinates = text
                    .replaceFirst("POINT ?\\(", "")
                    .replaceFirst("\\)", "")
                    .split(" ");

            double latitude = Double.parseDouble(coordinates[0]);
            double longitude = Double.parseDouble(coordinates[1]);

            return geometryFactory.createPoint(new Coordinate(latitude, longitude));
        } catch (Exception e) {
            return null;
        }
    }
}
