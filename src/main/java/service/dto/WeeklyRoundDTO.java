package service.dto;

import model.Coord;

public class WeeklyRoundDTO {

    private RoundDTO round;
    private String description;
    private String sinceHour;
    private String untilHour;
    private CoordDTO currentCoords;

    public RoundDTO getRound() {
        return round;
    }

    public void setRound(RoundDTO round) {
        this.round = round;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSinceHour() {
        return sinceHour;
    }

    public void setSinceHour(String sinceHour) {
        this.sinceHour = sinceHour;
    }

    public String getUntilHour() {
        return untilHour;
    }

    public void setUntilHour(String untilHour) {
        this.untilHour = untilHour;
    }

    public CoordDTO getCurrentCoords() {
        return currentCoords;
    }

    public void setCurrentCoords(CoordDTO currentCoords) {
        this.currentCoords = currentCoords;
    }
}
