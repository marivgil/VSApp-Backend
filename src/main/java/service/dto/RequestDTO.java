package service.dto;

import java.util.Date;
import java.util.List;

public class RequestDTO {

    private WeeklyRoundDTO weeklyRound;
    private Date date;
    private String preparedBy;
    private String reviewedBy;
    private List<ClothesDTO> clothes;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public WeeklyRoundDTO getWeeklyRound() {
        return weeklyRound;
    }

    public void setWeeklyRound(WeeklyRoundDTO weeklyRound) {
        this.weeklyRound = weeklyRound;
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

    public List<ClothesDTO> getClothes() {
        return clothes;
    }

    public void setClothes(List<ClothesDTO> clothes) {
        this.clothes = clothes;
    }

}
