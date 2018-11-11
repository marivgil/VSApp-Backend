package persistence.service;

import model.clothing.Clothing;
import model.clothingSize.ClothingSize;
import org.springframework.transaction.annotation.Transactional;
import persistence.repositories.ClothingRepository;
import persistence.repositories.ClothingSizeRepository;

import java.util.List;

public class ClothingService extends GenericService<Clothing>{

    private ClothingRepository repository;
    private ClothingSizeRepository clothingSizeRepository;

    public ClothingRepository getRepository() {
        return repository;
    }
    public void setRepository(ClothingRepository repository) {
        this.repository = repository;
    }


    public ClothingSizeRepository getClothingSizeRepository() {
        return clothingSizeRepository;
    }
    public void setClothingSizeRepository(ClothingSizeRepository clothingSizeRepository) {
        this.clothingSizeRepository = clothingSizeRepository;
    }

    // **************** SERVICIOS ****************************************

    @Transactional
    public List<ClothingSize> findAllSizesClothing(){
        return this.getClothingSizeRepository().findAll();
    }

    @Transactional
    public List<Clothing> findAllClothings() {
        return this.getRepository().findAll();
    }

}
