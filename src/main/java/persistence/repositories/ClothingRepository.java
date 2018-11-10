package persistence.repositories;

import model.clothing.Clothing;

public class ClothingRepository
        extends HibernateGenericDAO<Clothing>
        implements GenericRepository<Clothing> {

    @Override
    protected Class<Clothing> getDomainClass() {
        return Clothing.class;
    }
}
