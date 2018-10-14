package persistence.repositories;

import model.Request;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

public class RequestRepository
        extends HibernateGenericDAO<Request>
        implements GenericRepository<Request> {


    @Override
    protected Class<Request> getDomainClass() {
        return Request.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Request findRequestByIdRound(String round) {

        return (Request) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Request doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Request.class, "request").
                        createAlias("request.round","round")
                        .add(Restrictions.eq("round.name", round ))
                        ;
                return (Request) criteria.uniqueResult();
            }

        });

    }
}
