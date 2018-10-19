package model;

import java.util.Date;
import java.util.List;

public class Request extends Entity{

    private WeeklyRound weeklyRound;
    private Date date;
    private String preparedBy;
    private String reviewedBy;
    private List<Clothes> clothes;

    public Request(){}

    public WeeklyRound getWeeklyRound() {
        return weeklyRound;
    }

    public void setWeeklyRound(WeeklyRound weeklyRound) {
        this.weeklyRound = weeklyRound;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public List<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }
}
