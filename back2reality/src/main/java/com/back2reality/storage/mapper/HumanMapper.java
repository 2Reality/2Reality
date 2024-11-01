package com.back2reality.storage.mapper;

import com.back2reality.human.HumanForm;
import com.back2reality.human.HumanItem;
import com.back2reality.location.LocationFactory;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.entities.Human;
import com.back2reality.utils.MathUtils;
import org.locationtech.jts.geom.Point;

/**
 * @author FLIGHT
 */
public class HumanMapper {

    private final LocationFactory locationFactory;

    public HumanMapper(LocationFactory locationFactory) {
        this.locationFactory = locationFactory;
    }

    public HumanItem toHumanItem(Human human, RecommenderContext recommenderContext) {
        double distance = MathUtils.round(
                human.getLocation().distance(recommenderContext.location()) * 100, 2
        );
        return new HumanItem(
                human.getId(),
                human.getFullname(),
                human.getNickname(),
                human.getDescription(),
                human.getSex(),
                human.getBirthDate(),
                human.getGeo(),
                distance,
                HumanItem.DEFAULT_SCORE
        );
    }

    public Human toHuman(HumanForm humanForm) {
        Point location = locationFactory.toPoint(
                humanForm.longitude(),
                humanForm.latitude()
        );
        return new Human(
                humanForm.fullname(),
                humanForm.nickname(),
                humanForm.description(),
                humanForm.sex(),
                humanForm.birthDate(),
                humanForm.geo(),
                location
        );
    }
}
