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
        List<Clothes> listaRopa = pedido.getClothingMatrix(listClothing, listSizes);

        assertEquals(listaRopa.size(), 4);

        Clothes ropa = pedido.getClothes().get(0);
        assertEquals(ropa.getClothing(), remera);
        assertEquals(ropa.getSize(), xl);

        Clothes ropa2 = pedido.getClothes().get(1);
        assertEquals(ropa2.getClothing(), remera);
        assertEquals(ropa2.getSize(), talle46);

        Clothes ropa3 = pedido.getClothes().get(2);
        assertEquals(ropa3.getClothing(), pantalon);
        assertEquals(ropa3.getSize(), xl);

        Clothes ropa4 = pedido.getClothes().get(3);
        assertEquals(ropa4.getClothing(), pantalon);
        assertEquals(ropa4.getSize(), talle46);

    }
}
