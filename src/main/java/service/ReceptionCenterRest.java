package service;

import model.Location;
import model.ReceptionCenter;
import persistence.service.ReceptionCenterService;
import service.dto.LocationDTO;
import service.dto.ReceptionCenterDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/receptionCenter")
public class ReceptionCenterRest {

    private ReceptionCenterService receptionCenterService;

    public ReceptionCenterService getReceptionCenterService() {
        return this.receptionCenterService;
    }

    public void setReceptionCenterService(ReceptionCenterService receptionCenterService) {
        this.receptionCenterService = receptionCenterService;
    }

    @GET
    @Path("/findReceptionCenterByLocation/{location}")
    @Produces("application/json")
    public List<ReceptionCenterDTO> findReceptionCenterByLocation(@PathParam("location") final String location){
        return LRCToLRCDto(
                this.getReceptionCenterService().findReceptionCenterByLocation(location)
                );
    }



    @POST
    @Path("/createReceptionCenter")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createVehicleRest(ReceptionCenterDTO dto){
        ReceptionCenter rc = RcDTOtoRc(dto);
        this.getReceptionCenterService().save(rc);
        return Response.ok().build();
    }





    private ReceptionCenter RcDTOtoRc(ReceptionCenterDTO dto){
        ReceptionCenter rc = new ReceptionCenter();
        rc.setPhone(dto.getPhone());
        rc.setLocation(dto.getLocation());
        rc.setSurname(dto.getSurname());
        rc.setName(dto.getName());
        List<Location> ll = new ArrayList<>();
        for(LocationDTO l: dto.getNearbyLocations()){
            Location location = new Location();
            location.setNameLocation(l.getNameLocation());
            ll.add(location);
        }
        rc.setNearbyLocations(ll);

        return rc;
    }


    private List<ReceptionCenterDTO> LRCToLRCDto(List<ReceptionCenter> lrc){
        List<ReceptionCenterDTO> ldto = new ArrayList<>();
        for(ReceptionCenter rc: lrc){
            ldto.add(RCToRCDto(rc));
        }
        return ldto;
    }

    private ReceptionCenterDTO RCToRCDto(ReceptionCenter rc){
        ReceptionCenterDTO dto = new ReceptionCenterDTO();
        dto.setLocation(rc.getLocation());
        dto.setName(rc.getName());
        dto.setSurname(rc.getSurname());
        dto.setPhone(rc.getPhone());
        List<LocationDTO> ll = new ArrayList<>();
        for(Location l: rc.getNearbyLocations()){
            LocationDTO location = new LocationDTO();
            location.setNameLocation(l.getNameLocation());
            ll.add(location);
        }
        dto.setNearbyLocations(ll);
        return dto;
    }
}
