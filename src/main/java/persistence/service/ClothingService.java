package persistence.service;

import model.clothing.Clothing;
import model.clothing.ClothingDown;
import model.clothing.ClothingUp;
import model.clothingSize.ClothingDownSize;
import model.clothingSize.ClothingUpSize;
import org.springframework.transaction.annotation.Transactional;
import persistence.repositories.ClothingRepositoryDown;
import persistence.repositories.ClothingRepositoryUp;
import persistence.repositories.ClothingSizeRepositoryDown;
import persistence.repositories.ClothingSizeRepositoryUp;

import java.util.List;

public class ClothingService extends GenericService<Clothing>{

    private ClothingRepositoryUp upRepository;
    private ClothingRepositoryDown downRepository;
    private ClothingSizeRepositoryUp upClothingSizeRepository;
    private ClothingSizeRepositoryDown downClothingSizeRepository;

    public ClothingRepositoryUp getUpRepository() {
        return upRepository;
    }

    public void setUpRepository(ClothingRepositoryUp upRepository) {
        this.upRepository = upRepository;
    }

    public ClothingRepositoryDown getDownRepository() {
        return downRepository;
    }

    public void setDownRepository(ClothingRepositoryDown downRepository) {
        this.downRepository = downRepository;
    }

    public ClothingSizeRepositoryUp getUpClothingSizeRepository() {
        return upClothingSizeRepository;
    }

    public void setUpClothingSizeRepository(ClothingSizeRepositoryUp upClothingSizeRepository) {
        this.upClothingSizeRepository = upClothingSizeRepository;
    }

    public ClothingSizeRepositoryDown getDownClothingSizeRepository() {
        return downClothingSizeRepository;
    }

    public void setDownClothingSizeRepository(ClothingSizeRepositoryDown downClothingSizeRepository) {
        this.downClothingSizeRepository = downClothingSizeRepository;
    }

    // **************** SERVICIOS ****************************************

    @Transactional
    public List<ClothingUpSize> findAllSizesClothingUp(){
        return this.getUpClothingSizeRepository().findAll();
    }

    @Transactional
    public List<ClothingUp> findAllClothingsUp() {
        return this.getUpRepository().findAll();
    }

    @Transactional
    public List<ClothingDown> findAllClothingsDown() {
        return this.getDownRepository().findAll();
    }

    @Transactional
    public List<ClothingDownSize> fillAllSizesClothingDown() {
        return this.getDownClothingSizeRepository().findAll();
    }
}
