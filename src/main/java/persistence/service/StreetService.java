package persistence.service;

import model.WeeklyRound;
import persistence.repositories.RequestRepository;

import java.util.List;

public class StreetService extends GenericService<WeeklyRound>{

    private RequestRepository repository;

    public RequestRepository getRepository() {
        return repository;
    }

    public void setRepository(RequestRepository repository) {
        this.repository = repository;
    }

    /*public Request findRequestByIdRound(String round) {
        return this.getRepository().findRequestByIdRound(round);
    }
    */

    public List<WeeklyRound> findAllWeeklyRound() {
        return this.getRepository().findAllWeeklyRound();
    }
}
