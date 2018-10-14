package persistence.service;

import model.Request;
import persistence.repositories.RequestRepository;

public class StreetService extends GenericService<Request>{

    private RequestRepository repository;

    public RequestRepository getRepository() {
        return repository;
    }

    public void setRepository(RequestRepository repository) {
        this.repository = repository;
    }

    public Request findRequestByIdRound(String round) {
        return this.getRepository().findRequestByIdRound(round);
    }
}
