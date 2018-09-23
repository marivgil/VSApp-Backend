package persistence.service;

import model.HospitalProduct;
import persistence.repositories.HospitalProductRepository;

import java.util.List;

public class HospitalService  extends GenericService<HospitalProduct>{

    private HospitalProductRepository repository;

    public HospitalProductRepository getRepository() {
        return repository;
    }

    public void setRepository(HospitalProductRepository repository) {
        this.repository = repository;
    }

    public List<HospitalProduct> findByHospital(String hospital) {
        return this.getRepository().findByHospital(hospital);
    }
}
