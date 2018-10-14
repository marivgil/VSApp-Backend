package service;

import model.Clothes;
import model.Gender;
import model.Request;
import persistence.service.StreetService;
import service.dto.ClothesDTO;
import service.dto.RequestDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/streetService")
public class StreetRest {

    private StreetService streetService;

    public StreetService getStreetService() {
        return streetService;
    }

    public void setStreetService(StreetService streetService) {
        this.streetService = streetService;
    }

    @POST
    @Path("/createRequest")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createRequestRest(RequestDTO dto){
        this.getStreetService().save(requestDTOToRequest(dto));
        return Response.ok().build();
    }

    private Request requestDTOToRequest(RequestDTO dto) {
        Request r = new Request();
        r.setDate(dto.getDate());
        r.setPreparedBy(dto.getPreparedBy());
        r.setReviewedBy(dto.getReviewedBy());
        /*FIXME buscar el reound a la base*/
        //r.setRound(dto.getRound());
        r.setClothes(listClothesDTOToListClothes(dto.getClothes()));
        return r;
    }

    private List<Clothes> listClothesDTOToListClothes(List<ClothesDTO> listDto){
        List<Clothes> listC = new ArrayList<>();
        for(ClothesDTO dto: listDto){
            listC.add(clothesDTOToClothes(dto));
        }
        return listC;
    }

    private Clothes clothesDTOToClothes(ClothesDTO dto) {
        Clothes c = new Clothes();
        c.setGender(Gender.valueOf(dto.getGender()));
        c.setName(dto.getName());
        c.setQuantity(dto.getQuantity());
        c.setWaist(dto.getWaist());
        return c;
    }

    /*FIXME este servicio ahora debe buscar por el nombre del recorrido, ya no es más un string,ahora es un obejto*/
    @GET
    @Path("/findRequestByRound/{round}")
    @Produces("application/json")
    public RequestDTO findRequestByRound(@PathParam("round") final String round){
        Request request = this.getStreetService().findById(round);
        if (request==null)
            return null;
            else
                return requestToRequestDTO(request);
    }

    private RequestDTO requestToRequestDTO(Request r) {
        RequestDTO dto = new RequestDTO();
        dto.setDate(r.getDate());
        dto.setPreparedBy(r.getPreparedBy());
        dto.setReviewedBy(r.getReviewedBy());
        dto.setRound(r.getRound().getCode() + " - " + r.getRound().getName());
        dto.setClothes(listClothesToListClothesDTO(r.getClothes()));
        return dto;
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
        dto.setName(c.getName());
        dto.setQuantity(c.getQuantity());
        dto.setWaist(c.getWaist());
        return dto;
    }


}


