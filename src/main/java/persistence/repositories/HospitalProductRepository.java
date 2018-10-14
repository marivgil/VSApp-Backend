package persistence.repositories;

import model.HospitalProduct;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

public class HospitalProductRepository
        extends HibernateGenericDAO<HospitalProduct>
        implements GenericRepository<HospitalProduct> {

    @Override
    protected Class<HospitalProduct> getDomainClass() {
        return HospitalProduct.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<HospitalProduct> findByHospital(String hospital) {
        return (List<HospitalProduct>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<HospitalProduct> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(HospitalProduct.class, "product")
                        .createAlias("product.hospital","hospital")
                        .add(Restrictions.eq("hospital.name", hospital ))
                        ;
                return (List<HospitalProduct>)criteria.list();
            }

        });
    }
}
