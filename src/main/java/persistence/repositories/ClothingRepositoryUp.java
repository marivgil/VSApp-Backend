package persistence.repositories;

import model.clothing.ClothingUp;

public class ClothingRepositoryUp
        extends HibernateGenericDAO<ClothingUp>
        implements GenericRepository<ClothingUp> {

    @Override
    protected Class<ClothingUp> getDomainClass() {
        return ClothingUp.class;
    }
}
