package spring.boot.assessment.food;

import java.util.List;

public interface FoodService {

    public List<FoodEntity> findAll();

    public FoodEntity findById(int theId);

    public List<FoodEntity> belowPrice(int price);

    public void save(FoodEntity theFood);

    public void deleteById(int theId);

    public FoodEntity findByFromAndTo(String from, String to);
    
}