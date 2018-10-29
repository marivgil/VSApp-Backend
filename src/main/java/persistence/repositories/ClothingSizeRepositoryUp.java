package persistence.repositories;

import model.clothingSize.ClothingUpSize;

public class ClothingSizeRepositoryUp
        extends HibernateGenericDAO<ClothingUpSize>
        implements GenericRepository<ClothingUpSize> {


    @Override
    protected Class<ClothingUpSize> getDomainClass() {
        return ClothingUpSize.class;
    }
}
