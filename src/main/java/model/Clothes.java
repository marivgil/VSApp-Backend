package model;

import model.clothing.Clothing;
import model.clothingSize.ClothingSize;

public class Clothes extends Entity{

    private Clothing clothing;
    private ClothingSize size;
    private int quantity;
    private Gender gender;

    public Clothes(){}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
    }

    public ClothingSize getSize() {
        return size;
    }

    public void setSize(ClothingSize size) {
        this.size = size;
    }
}
