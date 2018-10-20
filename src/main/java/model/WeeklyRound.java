package model;

import java.time.LocalDateTime;

public class WeeklyRound extends Entity{

    private String description;
    private LocalDateTime sinceHour;
    private LocalDateTime untilHour;
    private Coord currentCoords;
    private Request request;
    private Round round;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSinceHour() {
        return sinceHour;
    }

    public void setSinceHour(LocalDateTime sinceHour) {
        this.sinceHour = sinceHour;
    }

    public LocalDateTime getUntilHour() {
        return untilHour;
    }

    public void setUntilHour(LocalDateTime untilHour) {
        this.untilHour = untilHour;
    }

    public Coord getCurrentCoords() {
        return currentCoords;
    }

    public void setCurrentCoords(Coord currentCoords) {
        this.currentCoords = currentCoords;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}
