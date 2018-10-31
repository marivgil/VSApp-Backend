package persistence.service;

import model.Round;
import persistence.repositories.RoundRepository;

import java.util.List;

public class RoundService  extends GenericService<Round>{

    private RoundRepository repository;

    @Override
    public RoundRepository getRepository() {
        return repository;
    }

    public void setRepository(RoundRepository repository) {
        this.repository = repository;
    }

    public List<Round> findAll() {
        return this.getRepository().findAll();
    }
}
