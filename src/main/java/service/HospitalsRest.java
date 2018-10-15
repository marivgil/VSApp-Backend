package service;

import model.Hospital;
import model.HospitalProduct;
import persistence.service.HospitalService;
import service.dto.HospitalDTO;
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
        hpdto.setHospital(hospitalToHospitalDTO(hp.getHospital()));
        hpdto.setQuantity(hp.getQuantity());
        hpdto.setName(hp.getName());
        hpdto.setType(hp.getType());
        return hpdto;
    }

    private HospitalDTO hospitalToHospitalDTO(Hospital h) {
        HospitalDTO dto = new HospitalDTO();
        dto.setName(h.getName());
        dto.setPhone(h.getPhone());
        dto.setAddress(h.getAddress());
        return dto;
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
        hp.setHospital(hospitalDTOToHospital(hpdto.getHospital()));
        hp.setQuantity(hpdto.getQuantity());
        hp.setName(hpdto.getName());
        hp.setType(hpdto.getType());
        return hp;
    }

    private Hospital hospitalDTOToHospital(HospitalDTO dto) {
        Hospital h = new Hospital();
        h.setName(dto.getName());
        h.setPhone(dto.getPhone());
        h.setAddress(dto.getAddress());
        return h;
    }

    @GET
    @Path("/getAllHospitals")
    @Produces("application/json")
    public List<HospitalDTO> getAllHospitals(){
        return listHospitalToListHospitalDTO(this.getHospitalService().getAllHospitals());
    }

    private List<HospitalDTO> listHospitalToListHospitalDTO(List<Hospital> lh){
        List<HospitalDTO> ldto = new ArrayList<>();
        for(Hospital h: lh){
            ldto.add(hospitalToHospitalDTO(h));
        }
        return ldto;
    }
}
