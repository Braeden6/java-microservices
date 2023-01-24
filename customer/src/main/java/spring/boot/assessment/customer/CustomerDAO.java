package spring.boot.assessment.customer;

import java.util.List;

public interface CustomerDAO {
    
        public List<CustomerEntity> findAll();

        public CustomerEntity findByFromAndTo(String from, String to);

        public List<FoodEntity> findTopFood(int amount);
    
        public CustomerEntity findById(int theId);
    
        public void save(CustomerEntity theFood);
    
        public void deleteById(int theId);
        
}
