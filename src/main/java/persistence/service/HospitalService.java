package persistence.service;

import model.Hospital;
import model.HospitalProduct;
import persistence.repositories.HospitalProductRepository;
import persistence.repositories.HospitalRepository;
import java.util.List;

public class HospitalService  extends GenericService<HospitalProduct>{

    private HospitalProductRepository repository;
    private HospitalRepository hospitalRepository;

    public HospitalRepository getHospitalRepository() {
        return hospitalRepository;
    }

    public void setHospitalRepository(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalProductRepository getRepository() {
        return repository;
    }

    public void setRepository(HospitalProductRepository repository) {
        this.repository = repository;
    }

    public List<HospitalProduct> findByHospital(String hospital) {
        return this.getRepository().findByHospital(hospital);
    }

    public List<Hospital> getAllHospitals() {
        return this.getHospitalRepository().findAll();
    }
}
