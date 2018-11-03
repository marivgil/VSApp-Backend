package persistence.repositories;

import model.clothingSize.ClothingDownSize;

public class ClothingSizeRepositoryDown
        extends HibernateGenericDAO<ClothingDownSize>
        implements GenericRepository<ClothingDownSize> {

    @Override
    protected Class<ClothingDownSize> getDomainClass() {
        return ClothingDownSize.class;
    }
}
