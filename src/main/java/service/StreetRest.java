package service;

import model.*;
import model.clothing.Clothing;
import model.clothingsize.ClothingSize;
import persistence.service.RoundService;
import persistence.service.StreetService;
import service.dto.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/streetService")
public class StreetRest {

    private StreetService streetService;
    private RoundService roundService;

    public StreetService getStreetService() {
        return streetService;
    }
    public void setStreetService(StreetService streetService) {
        this.streetService = streetService;
    }

    public RoundService getRoundService() {
        return roundService;
    }
    public void setRoundService(RoundService roundService) {
        this.roundService = roundService;
    }


    @GET
    @Path("/getAllRounds")
    @Produces("application/json")
    public List<RoundDTO> getAllRounds(){
        return listRoundToListRoundDTO(this.getRoundService().findAll());
    }

    private List<RoundDTO> listRoundToListRoundDTO(List<Round> lr){
        List<RoundDTO> listrd = new ArrayList<>();
        for(Round r: lr){
            listrd.add(roundToRoundDTO(r));
        }
        return listrd;
    }

    @PUT
    @Path("/updateRequest")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateRequestRest(WeeklyRoundDTO dto){
        WeeklyRound weeklyRound = weeklyRoundDTOToWeeklyRound(dto);
        this.getStreetService().merge(weeklyRound);
        return Response.ok().build();
    }

    @POST
    @Path("/createRequest")
    @Produces("application/json")
    @Consumes("application/json")
    public WeeklyRoundDTO createRequestRest(WeeklyRoundDTO dto){
        WeeklyRound wr = this.getStreetService().merge(weeklyRoundDTOToWeeklyRound(dto));
        return weeklyRoundToWeeklyRoundDTO(wr);
    }

    private WeeklyRound weeklyRoundDTOToWeeklyRound(WeeklyRoundDTO dto) {
        WeeklyRound wr = new WeeklyRound();
        wr.setId(dto.getId());
        wr.setCurrentCoords(coordDTOToCoord(dto.getCurrentCoords()));
        wr.setDescription(dto.getDescription());
/*        wr.setSinceHour(
                LocalDateTime.of(
                        Integer.valueOf(dto.getSinceHour().substring(0,4)),
                        Integer.valueOf(dto.getSinceHour().substring(5,7)),
                        Integer.valueOf(dto.getSinceHour().substring(8,10)),
                        0,
                        0
                        0
                )
        );
        wr.setUntilHour(
                LocalDateTime.of(
                        Integer.valueOf(dto.getUntilHour().substring(0,4)),
                        Integer.valueOf(dto.getUntilHour().substring(5,7)),
                        Integer.valueOf(dto.getUntilHour().substring(8,10)),
                        0,
                        0
                )
        );
*/
        wr.setRequest(requestDTOToRequest(dto.getRequest()));
        wr.setRound(roundDTOToRound(dto.getRound()));
        return wr;
    }


    private Request requestDTOToRequest(RequestDTO dto) {
        Request r = new Request();
        r.setDate(dto.getDate());
        r.setPreparedBy(dto.getPreparedBy());
        r.setReviewedBy(dto.getReviewedBy());
        r.setClothes(listClothesDTOToListClothes(dto.getClothes()));
        r.setOthers(dto.getOthers());
        return r;
    }


    private Coord coordDTOToCoord(CoordDTO dto){
        Coord c = new Coord();
        c.setLat(dto.getLat());
        c.setLng(dto.getLng());
        return c;
    }

    private Round roundDTOToRound(RoundDTO dto) {
        Round r = new Round();
        r.setCode(dto.getCode());
        r.setName(dto.getName());
        r.setCoordinator(dto.getCoordinator());
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
        Clothing clothing = new Clothing();
        clothing.setName(dto.getName());
        c.setClothing(clothing);
        c.setQuantity(dto.getQuantity());
        ClothingSize cs = new ClothingSize();
        cs.setSize(dto.getSize());
        c.setSize(cs);
        return c;
    }

    @GET
    @Path("/findAllRequests")
    @Produces("application/json")
    public List<WeeklyRoundDTO> findAllRequests(){
        List<WeeklyRound> weeklyRound = this.getStreetService().findAllWeeklyRound();
        if (weeklyRound==null)
            return null;
            else
                return listWeeklyRoundToListWeeklyRoundDTO(weeklyRound);
    }

    private List<WeeklyRoundDTO> listWeeklyRoundToListWeeklyRoundDTO(List<WeeklyRound> lwr) {
        List<WeeklyRoundDTO> listdto = new ArrayList<>();
        for(WeeklyRound wr: lwr){
            listdto.add(weeklyRoundToWeeklyRoundDTO(wr));
        }
        return listdto;
    }

    private RequestDTO requestToRequestDTO(Request r) {
        RequestDTO dto = new RequestDTO();
        dto.setDate(r.getDate());
        dto.setPreparedBy(r.getPreparedBy());
        dto.setReviewedBy(r.getReviewedBy());
        dto.setClothes(listClothesToListClothesDTO(r.getClothes()));
        dto.setOthers(r.getOthers());
        return dto;
    }

    private WeeklyRoundDTO weeklyRoundToWeeklyRoundDTO(WeeklyRound wr) {
        WeeklyRoundDTO dto = new WeeklyRoundDTO();
        dto.setId(wr.getId());
        dto.setCurrentCoords(coordToCoordDTO(wr.getCurrentCoords()));
        dto.setDescription(wr.getDescription());
/*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatSinceDate = wr.getSinceHour().format(formatter);
        dto.setSinceHour(formatSinceDate);
        String formatUntilDate = wr.getUntilHour().format(formatter);
        dto.setUntilHour(formatUntilDate);
*/
        dto.setRequest(requestToRequestDTO(wr.getRequest()));
        dto.setRound(roundToRoundDTO(wr.getRound()));
        return dto;
    }

    private RoundDTO roundToRoundDTO(Round round) {
        RoundDTO dto = new RoundDTO();
        dto.setCode(round.getCode());
        dto.setName(round.getName());
        dto.setCoordinator(round.getCoordinator());
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
        dto.setName(c.getClothing().getName());
        dto.setQuantity(c.getQuantity());
        dto.setSize(c.getSize().getSize());
        return dto;
    }

    private CoordDTO coordToCoordDTO(Coord c){
        CoordDTO dto = new CoordDTO();
        dto.setLat(c.getLat());
        dto.setLng(c.getLng());
        return dto;
    }
}
