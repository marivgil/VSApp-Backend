package model;

import java.time.LocalDateTime;

public class WeeklyRound extends Entity{

    private Round round;
    private String description;
    private LocalDateTime sinceHour;
    private LocalDateTime untilHour;
    private Coord currentCoords;
}
