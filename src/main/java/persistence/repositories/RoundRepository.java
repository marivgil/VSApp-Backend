package persistence.repositories;

import model.Round;

public class RoundRepository
        extends HibernateGenericDAO<Round>
        implements GenericRepository<Round> {


    @Override
    protected Class<Round> getDomainClass() {
        return Round.class;
    }
}
