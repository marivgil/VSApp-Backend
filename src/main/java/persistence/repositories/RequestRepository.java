package persistence.repositories;

import model.Request;

public class RequestRepository
        extends HibernateGenericDAO<Request>
        implements GenericRepository<Request> {


    @Override
    protected Class<Request> getDomainClass() {
        return Request.class;
    }
}
