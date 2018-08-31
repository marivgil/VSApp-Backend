package persistence.service;

import model.ReceptionCenter;
import org.springframework.transaction.annotation.Transactional;
import persistence.repositories.ReceptionCenterRepository;

import java.util.List;

public class ReceptionCenterService extends GenericService<ReceptionCenter>{

    private ReceptionCenterRepository repository;
    public ReceptionCenterRepository getRepository() {
        return this.repository;
    }
    public void setRepository(final ReceptionCenterRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<ReceptionCenter> findReceptionCenterByLocation(String location) {
        return this.getRepository().findReceptionCenterByLocation(location);
    }
}
