package model;

import model.clothing.Clothing;
import model.clothingSize.ClothingSize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Request extends Entity{

    private Date date;
    private String preparedBy;
    private String reviewedBy;
    private List<Clothes> clothes;

    public Request(){}

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

    public List<Clothes> getClothingMatrix(List<Clothing> listClothing, List<ClothingSize> listSizes, List<Gender> listGenders) {

        this.clothes = new ArrayList<>();
/*
        Clothes[][][] matriz = new Clothes[listClothing.size()][listSizes.size()][listGenders.size()];

        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                for(int z=0; z < matriz[y].length; z++){
                    Clothes clothe = new Clothes();
                    clothe.setQuantity(0);
                    clothe.setClothing(listClothing.get(x));
                    clothe.setSize(listSizes.get(y));
                    clothe.setGender(listGenders.get(z));
                    this.clothes.add(clothe);
                }
            }
        }




    OTRA MANERA DE HACER LO MISMO
*/
        for(Clothing c: listClothing){
            for(ClothingSize s: listSizes){
                for(Gender g: listGenders){
                    Clothes clothe = new Clothes();
                    clothe.setQuantity(0);
                    clothe.setClothing(c);
                    clothe.setSize(s);
                    clothe.setGender(g);
                    this.clothes.add(clothe);
                }
            }
        }

        return this.clothes;
    }
}
