package com.back2reality.human;

import com.back2reality.image.ImageItem;
import com.back2reality.recommender.item.WithDistance;
import com.back2reality.recommender.item.WithScore;

import java.time.LocalDate;

/**
 * @author FLIGHT
 */
public record HumanItem(
        long id,
        String fullname,
        String nickname,
        String description,
        Sex sex,
        LocalDate birthDate,
        ImageItem image,
        String geo,
        double longitude,
        double latitude,
        double distance,
        double score
) implements WithScore, WithDistance {


}
