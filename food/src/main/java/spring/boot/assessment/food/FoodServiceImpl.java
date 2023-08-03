package spring.boot.assessment.food;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDAO foodDAO;

    @Override
    @Transactional
    public List<FoodEntity> findAll() {
        return foodDAO.findAll();
    }

    @Override
    public FoodEntity findById(int theId) {
        return foodDAO.findById(theId);
    }

    @Override
    public void save(FoodEntity theFood) {
        foodDAO.save(theFood);
    }

    @Override
    public void deleteById(int theId) {
        foodDAO.deleteById(theId);
    }

    @Override
    public FoodEntity findByFromAndTo(String from, String to) {
        return foodDAO.findByFromAndTo(from, to);
    }

    @Override
    public List<FoodEntity> belowPrice(int price) {
        return foodDAO.belowPrice(price);
    }
    
}
