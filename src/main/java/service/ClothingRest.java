package service;

import model.clothing.Clothing;
import model.clothingSize.ClothingSize;
import persistence.service.ClothingService;
import service.dto.ClothingDTO;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    @GET
    @Path("/findAllClothings/{genders}")
    @Produces("application/json")
    @Consumes("application/json")
    public List<ClothingDTO> findAllClothings(@PathParam("genders") final String genders) {
        return listClothingToListClothingDTO(this.getClothingService().
                findAllClothings(CommaSeparatedList(genders)));
    }

    private List<String> CommaSeparatedList(String list){
        return Arrays.asList(list.split(","));
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
        return this.getClothingService().findAllSizesClothing();
    }

}
