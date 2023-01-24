package spring.boot.assessment.food;

import java.util.List;

public interface FoodDAO {
    
        public List<FoodEntity> findAll();

        public FoodEntity findByFromAndTo(String from, String to);

        public List<FoodEntity> belowPrice(int price);
    
        public FoodEntity findById(int theId);
    
        public void save(FoodEntity theFood);
    
        public void deleteById(int theId);
        
}
