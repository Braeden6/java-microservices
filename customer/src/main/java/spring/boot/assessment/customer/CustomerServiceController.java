package spring.boot.assessment.customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FoodProxy proxy;


    @GetMapping("/getCustomer")
    public List<CustomerEntity> retrieveExchangeValue() {
       logger.info("Customer Service - get all customers");
        return customerService.findAll();
    }

    @GetMapping("/getTopFood/{amount}")
    public List<FoodEntity> getTopFood(@PathVariable int amount) {
        logger.info("Customer Service - get top {} food from food service", amount);
        List<CustomerEntity> customerList = customerService.findAll();
        List<FoodEntity> foodList = new ArrayList<>();
        for (CustomerEntity customer : customerList) {
            foodList.addAll(customer.getFood());
        }
        Set<FoodEntity> foodSet = new HashSet<>(foodList);
        Map<FoodEntity, Long> foodMap = foodSet.stream().collect(Collectors.toMap(Function.identity(), food -> foodList.stream().filter(f -> f.equals(food)).count()));
        List<FoodEntity> topFoodList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            if (foodMap.isEmpty()) {
                break;
            }
            FoodEntity food = foodMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
            topFoodList.add(food);
            foodMap.remove(food);
        }
        System.out.print(foodMap);
        return topFoodList;
    }


    @GetMapping("/getFood")
    public List<FoodEntity> getAllFoods() {
        logger.info("Customer Service - get all food from food service");
        List<FoodEntity> foodList = proxy.getAllFood();
        return foodList;
    }

    @GetMapping("/getFoodBelow/{price}")
    public List<FoodEntity> getFoodBelow(@PathVariable int price) {
        logger.info("Customer Service - get all food below {} from food service", price);
        List<FoodEntity> foodList = proxy.foodPriceBelow(price);
        return foodList;
    }    
}
