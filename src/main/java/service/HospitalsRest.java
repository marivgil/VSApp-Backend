package service;

import model.HospitalProduct;
import persistence.service.HospitalService;
import service.dto.HospitalProductDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/hospitalService")
public class HospitalsRest {

    private HospitalService hospitalService;

    public HospitalService getHospitalService() {
        return hospitalService;
    }

    public void setHospitalService(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GET
    @Path("/findProductsByHospital/{hospital}")
    @Produces("application/json")
    public List<HospitalProductDTO> findProductsByHospital(@PathParam("hospital") final String hospital){
        return listProductToListProductDTO(this.getHospitalService().findByHospital(hospital));
    }

    private List<HospitalProductDTO> listProductToListProductDTO(List<HospitalProduct> lhp){
        List<HospitalProductDTO> lhpdto = new ArrayList<>();
        for(HospitalProduct hp: lhp){
            lhpdto.add(productToProductDTO(hp));
        }
        return lhpdto;
    }

    private HospitalProductDTO productToProductDTO(HospitalProduct hp){
        HospitalProductDTO hpdto = new HospitalProductDTO();
        hpdto.setHospital(hp.getHospital());
        hpdto.setQuantity(hp.getQuantity());
        hpdto.setName(hp.getName());
        hpdto.setType(hp.getType());
        return hpdto;
    }

    @POST
    @Path("/createHospitalProduct")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createReceptionCenterRest(HospitalProductDTO dto){
        HospitalProduct p = productDTOToProduct(dto);
        this.getHospitalService().save(p);
        return Response.ok().build();
    }

    private HospitalProduct productDTOToProduct(HospitalProductDTO hpdto){
        HospitalProduct hp = new HospitalProduct();
        hp.setHospital(hpdto.getHospital());
        hp.setQuantity(hpdto.getQuantity());
        hp.setName(hpdto.getName());
        hp.setType(hpdto.getType());
        return hp;
    }

    @GET
    @Path("/getAllNamesHospitals")
    @Produces("application/json")
    public List<String> getAllNamesHospitals(){
        return this.getHospitalService().getAllNamesHospitals();
    }
}
