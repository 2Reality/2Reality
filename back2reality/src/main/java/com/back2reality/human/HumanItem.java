package com.back2reality.human;

import com.back2reality.recommender.item.WithDistance;
import com.back2reality.recommender.item.WithScore;

/**
 * @author FLIGHT
 */
public record HumanItem(
        long id,
        String fullname,
        String nickname,
        String description,
        Sex sex,
        int age,
        String geo,
        double distance,
        double score
) implements WithScore, WithDistance {


}
