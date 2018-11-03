package persistence.repositories;

import model.clothing.ClothingDown;

public class ClothingRepositoryDown
        extends HibernateGenericDAO<ClothingDown>
        implements GenericRepository<ClothingDown>{

    @Override
    protected Class<ClothingDown> getDomainClass() {
        return ClothingDown.class;
    }
}
