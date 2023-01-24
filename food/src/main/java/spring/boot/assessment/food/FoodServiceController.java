package spring.boot.assessment.food;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodService foodService;

    @Autowired
    private CustomerProxy proxy;

    @GetMapping("/getFood")
    public List<FoodEntity> getAllGood() {
        logger.info("Food Service - get all food");
        return foodService.findAll();
    }

    @GetMapping("/getFoodBelow/{price}")
    public List<FoodEntity> getAllGood(@PathVariable int price) {
        logger.info("Food Service - get all food below {}", price);
        return foodService.belowPrice(price);
    }

    @GetMapping("/getCustomer")
    public List<CustomerEntity> getAllCustomers() {
        logger.info("Food Service - get all customers from customer service");
        List<CustomerEntity> customerList = proxy.getAllCustomers();
        return customerList;
    }

    @GetMapping("/getTopFood/{amount}")
    public List<FoodEntity> getTopFood(@PathVariable int amount) {
        logger.info("Food Service - get top {} food from customer service", amount);
        List<FoodEntity> foodList = proxy.getTopFood(amount);
        return foodList;
    }

    // top 3 selling food


    
}
