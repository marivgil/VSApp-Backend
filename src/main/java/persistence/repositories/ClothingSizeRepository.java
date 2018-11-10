package persistence.repositories;

import model.clothingSize.ClothingSize;

public class ClothingSizeRepository
        extends HibernateGenericDAO<ClothingSize>
        implements GenericRepository<ClothingSize> {


    @Override
    protected Class<ClothingSize> getDomainClass() {
        return ClothingSize.class;
    }
}
