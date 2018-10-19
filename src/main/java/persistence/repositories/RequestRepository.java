package persistence.repositories;

import model.Request;
import model.WeeklyRound;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

public class RequestRepository
        extends HibernateGenericDAO<WeeklyRound>
        implements GenericRepository<WeeklyRound> {


    @Override
    protected Class<WeeklyRound> getDomainClass() {
        return WeeklyRound.class;
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Request findAllRoundsWithRequest(String round) {

        return (Request) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Request doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Request.class, "request").
                        createAlias("request.weeklyRound","weeklyRound").
                        createAlias("weeklyRound.round","round")
                        .add(Restrictions.eq("round.name", round ))
                        ;
                return (Request) criteria.uniqueResult();
            }

        });

    }
}
