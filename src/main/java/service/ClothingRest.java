package service;

import model.clothing.Clothing;
import model.clothingSize.ClothingSize;
import persistence.service.ClothingService;
import service.dto.ClothingDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/clothingService")
public class ClothingRest {

    private ClothingService clothingService;

    public ClothingService getClothingService() {
        return clothingService;
    }

    public void setClothingService(ClothingService clothingService) {
        this.clothingService = clothingService;
    }
/*
    @GET
    @Path("/findAllClothingsUp")
    @Produces("application/json")
    public List<ClothesDTO> findAllClothingsUp() {
        List clothings = this.getClothingService().findAllClothingsUp();
        List clothingSizes = this.getClothingService().findAllSizesClothingUp();

        List<Gender> genders = new ArrayList<>();
        genders.add(Gender.HOMBRE);
        genders.add(Gender.MUJER);

        Request request = new Request();
        return listClothesToListClothesDTO(request.getClothingMatrix(clothings, clothingSizes, genders));
    }


    @GET
    @Path("/findAllClothingsDown")
    @Produces("application/json")
    public List<ClothesDTO> findAllClothingsDown() {
        List clothings = this.getClothingService().findAllClothingsDown();
        List clothingSizes = this.getClothingService().fillAllSizesClothingDown();

        List<Gender> genders = new ArrayList<>();
        genders.add(Gender.HOMBRE);
        genders.add(Gender.MUJER);

        Request request = new Request();
        return listClothesToListClothesDTO(request.getClothingMatrix(clothings, clothingSizes, genders));
    }

    private List<ClothesDTO> listClothesToListClothesDTO(List<Clothes> clothes) {
        List<ClothesDTO> listdto = new ArrayList<>();
        for(Clothes c: clothes){
            listdto.add(clothesToClothesDTO(c));
        }
        return listdto;
    }

    private ClothesDTO clothesToClothesDTO(Clothes c) {
        ClothesDTO dto = new ClothesDTO();
        dto.setGender(c.getGender().toString());
        dto.setName(c.getClothing().getName());
        dto.setQuantity(c.getQuantity());
        dto.setSize(c.getSize().getSize());
        return dto;
    }
*/

    @GET
    @Path("/findAllClothings")
    @Produces("application/json")
    public List<ClothingDTO> findAllClothings() {
        return listClothingToListClothingDTO(this.getClothingService().findAllClothings());
    }

    private List<ClothingDTO> listClothingToListClothingDTO(List<Clothing> clothes) {
        List<ClothingDTO> listdto = new ArrayList<>();
        for(Clothing c: clothes){
            listdto.add(clothingToClothingDTO(c));
        }
        return listdto;
    }

    private ClothingDTO clothingToClothingDTO(Clothing c) {
        ClothingDTO dto = new ClothingDTO();
        dto.setName(c.getName());
        return dto;
    }

    @GET
    @Path("/findAllSizeClothings")
    @Produces("application/json")
    public List<ClothingSize> findAllSizeClothings() {
        //return listSizeClothingToListSizeClothingDTO(this.getClothingService().findAllSizesClothing());
        return this.getClothingService().findAllSizesClothing();
    }

}
