package model;

import model.clothing.Clothing;
import model.clothing.ClothingDown;
import model.clothing.ClothingUp;
import model.clothingSize.ClothingDownSize;
import model.clothingSize.ClothingSize;
import model.clothingSize.ClothingUpSize;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingTestCase {

    @Test
    public void debeArmarMatrizRopaArriba() {

        //simula consulta a la base
        List<Clothing> listClothing = new ArrayList<>();
        List<ClothingSize> listSizes = new ArrayList<>();

        Clothing remera = new ClothingUp();
        Clothing pantalon = new ClothingDown();

        ClothingUpSize xl = new ClothingUpSize();
        ClothingSize talle46 = new ClothingDownSize();

        listClothing.add(remera);
        listClothing.add(pantalon);

        listSizes.add(xl);
        listSizes.add(talle46);


        Request pedido = new Request();
        List<Gender> genders = new ArrayList<>();
        genders.add(Gender.HOMBRE);
        genders.add(Gender.MUJER);
        List<Clothes> listaRopa = pedido.getClothingMatrix(listClothing, listSizes, genders);

        assertEquals(listaRopa.size(), 8);

        Clothes ropa = pedido.getClothes().get(0);
        assertEquals(ropa.getClothing(), remera);
        assertEquals(ropa.getSize(), xl);
        assertEquals(ropa.getGender(), Gender.HOMBRE);

        Clothes ropa2 = pedido.getClothes().get(1);
        assertEquals(ropa2.getClothing(), remera);
        assertEquals(ropa2.getSize(), xl);
        assertEquals(ropa2.getGender(), Gender.MUJER);

        Clothes ropa3 = pedido.getClothes().get(2);
        assertEquals(ropa3.getClothing(), remera);
        assertEquals(ropa3.getSize(), talle46);
        assertEquals(ropa3.getGender(), Gender.HOMBRE);

        Clothes ropa4 = pedido.getClothes().get(3);
        assertEquals(ropa4.getClothing(), remera);
        assertEquals(ropa4.getSize(), talle46);
        assertEquals(ropa4.getGender(), Gender.MUJER);

        Clothes ropa5 = pedido.getClothes().get(4);
        assertEquals(ropa5.getClothing(), pantalon);
        assertEquals(ropa5.getSize(), xl);
        assertEquals(ropa5.getGender(), Gender.HOMBRE);

        Clothes ropa6 = pedido.getClothes().get(5);
        assertEquals(ropa6.getClothing(), pantalon);
        assertEquals(ropa6.getSize(), xl);
        assertEquals(ropa6.getGender(), Gender.MUJER);

        Clothes ropa7 = pedido.getClothes().get(6);
        assertEquals(ropa7.getClothing(), pantalon);
        assertEquals(ropa7.getSize(), talle46);
        assertEquals(ropa7.getGender(), Gender.HOMBRE);

        Clothes ropa8 = pedido.getClothes().get(7);
        assertEquals(ropa8.getClothing(), pantalon);
        assertEquals(ropa8.getSize(), talle46);
        assertEquals(ropa8.getGender(), Gender.MUJER);
    }
}
