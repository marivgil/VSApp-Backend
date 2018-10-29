package persistence.service;

import model.clothing.Clothing;
import model.clothing.ClothingUp;
import model.clothingSize.ClothingSize;
import org.springframework.transaction.annotation.Transactional;
import persistence.repositories.ClothingRepositoryDown;
import persistence.repositories.ClothingRepositoryUp;
import persistence.repositories.ClothingSizeRepository;

import java.util.List;

public class ClothingService extends GenericService<Clothing>{

    private ClothingRepositoryUp upRepository;
    private ClothingRepositoryDown downRepository;
    private ClothingSizeRepository clothingSizeRepository;

    public ClothingRepositoryUp getUpRepository() {
        return upRepository;
    }

    public ClothingRepositoryDown getDownRepository() {
        return downRepository;
    }

    public ClothingSizeRepository getClothingSizeRepository() {
        return clothingSizeRepository;
    }

    public void setUpRepository(ClothingRepositoryUp upRepository) {
        this.upRepository = upRepository;
    }

    public void setDownRepository(ClothingRepositoryDown downRepository) {
        this.downRepository = downRepository;
    }

    public void setClothingSizeRepository(ClothingSizeRepository clothingSizeRepository) {
        this.clothingSizeRepository = clothingSizeRepository;
    }

    @Transactional
    public List<ClothingSize> fillAllClothingSizes() {
        return this.getClothingSizeRepository().findAll();
    }

    @Transactional
    public List<ClothingUp> findAllClothingsUp() {
        return this.getUpRepository().findAll();
    }
}
