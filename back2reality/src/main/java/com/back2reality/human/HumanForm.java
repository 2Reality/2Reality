package com.back2reality.human;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public record HumanForm(
        String fullname,
        String nickname,
        String description,
        Sex sex,
        LocalDateTime birthDate,
        String geo,
        double longitude,
        double latitude
) {
}
