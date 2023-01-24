package spring.boot.assessment.customer;

import java.util.List;

public interface CustomerService {

    public List<CustomerEntity> findAll();

    public CustomerEntity findById(int theId);

    public List<FoodEntity> findTopFood(int amount);

    public void save(CustomerEntity theCustomer);

    public void deleteById(int theId);

    public CustomerEntity findByFromAndTo(String from, String to);
    
}