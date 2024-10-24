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
    public Point deserialize(JsonParser jp, DeserializationContext ctxt) {

        try {
            String text = jp.getText();
            if(text == null || text.isEmpty())
                return null;

            String[] coordinates = text.replaceFirst("POINT ?\\(", "").replaceFirst("\\)", "").split(" ");
            double lat = Double.parseDouble(coordinates[0]);
            double lon = Double.parseDouble(coordinates[1]);

            return geometryFactory.createPoint(new Coordinate(lat, lon));
        }
        catch(Exception e){
            return null;
        }
    }
}
