package com.back2reality.human;

/**
 * @author FLIGHT
 */
public record HumanForm(
        String fullname,
        String nickname,
        String description,
        Sex sex,
        int age,
        String geo,
        double longitude,
        double latitude
) {
}
