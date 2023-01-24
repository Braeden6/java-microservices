package spring.boot.assessment.customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<CustomerEntity> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public CustomerEntity findById(int theId) {
        return null;
    }

    @Override
    public void save(CustomerEntity theFood) {
    }

    @Override
    public void deleteById(int theId) {
    }

    @Override
    public CustomerEntity findByFromAndTo(String from, String to) {
        return customerDAO.findByFromAndTo(from, to);
    }

    @Override
    public List<FoodEntity> findTopFood(int amount) {
        return customerDAO.findTopFood(amount);
    }
    
}
