package persistence.repositories;

import model.ReceptionCenter;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceptionCenterRepository
        extends HibernateGenericDAO<ReceptionCenter>
        implements GenericRepository<ReceptionCenter> {


    @Override
    protected Class<ReceptionCenter> getDomainClass() {
        return ReceptionCenter.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<ReceptionCenter> findReceptionCenterByLocation(String location) {

        return (List<ReceptionCenter>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<ReceptionCenter> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(ReceptionCenter.class, "recepCenter").
                        createAlias("recepCenter.nearbyLocations","locations")
                        .add(Restrictions.eq("locations.nameLocation", location ))
                        ;
                return (List<ReceptionCenter>)criteria.list();
            }

        });
    }
}
