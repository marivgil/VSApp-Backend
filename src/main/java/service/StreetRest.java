package service;

import model.Request;
import persistence.service.StreetService;
import service.dto.RequestDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
        r.setRound(dto.getRound());
        return r;
    }
}


