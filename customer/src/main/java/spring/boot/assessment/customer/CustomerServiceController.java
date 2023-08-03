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

    // return the top {amount} food for all customers
    @GetMapping("/getTopFood/{amount}")
    public List<FoodEntity> getTopFood(@PathVariable int amount) {
        // use logger to log the info of the request
        logger.info("Customer Service - get top {} food", amount);
        // get a list of all food from each of the customers
        List<FoodEntity> foodList = customerService.findAll().stream()
            .map(customer -> customer.getFood())
            .flatMap(List::stream)
            .collect(Collectors.toList());
        // get the frequency of each food in the list
        Map<FoodEntity, Long> foodFrequency = foodList.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // map the frequency to the food to the food entity and sort the list from highest to lowest
        List<FoodEntity> sortedFoodList = foodFrequency.entrySet().stream()
            .sorted(Map.Entry.<FoodEntity, Long>comparingByValue().reversed())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        // print the frequency of each food with a header
        System.out.println("Food Frequency");
        foodFrequency.forEach((food, frequency) -> System.out.println(food.getDescription() + " - " + frequency));
        // print the top {amount} food with a header
        System.out.println("Top " + amount + " Food");
        sortedFoodList.subList(0, amount).forEach(food -> System.out.println(food.getDescription()));
        // return the top {amount} food
        return sortedFoodList.subList(0, amount);

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
