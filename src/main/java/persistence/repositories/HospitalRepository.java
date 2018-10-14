package persistence.repositories;

import model.Hospital;

public class HospitalRepository
        extends HibernateGenericDAO<Hospital>
        implements GenericRepository<Hospital> {

    @Override
    protected Class<Hospital> getDomainClass() {
        return Hospital.class;
    }

}
