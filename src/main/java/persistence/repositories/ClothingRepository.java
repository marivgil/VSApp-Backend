package persistence.repositories;

import model.clothing.Clothing;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

public class ClothingRepository
        extends HibernateGenericDAO<Clothing>
        implements GenericRepository<Clothing> {

    @Override
    protected Class<Clothing> getDomainClass() {
        return Clothing.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Clothing> findAllClothings(List<String> genders) {
        return (List<Clothing>) this.getHibernateTemplate().execute(new HibernateCallback() {
             @Override
             public List<Clothing> doInHibernate(final Session session) throws HibernateException {
                 Criteria criteria = session.createCriteria(Clothing.class, "clothing")
                         .add(Restrictions.in("clothing.code", genders ))
                         ;
                 return (List<Clothing>)criteria.list();
                }
        });
    }
}
