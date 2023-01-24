package spring.boot.assessment.customer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="food-service")
public interface FoodProxy {


    @GetMapping("/getFoodBelow/{price}")
	public List<FoodEntity> foodPriceBelow
		(@PathVariable("price") int price);

	@GetMapping("/getFood")
	public List<FoodEntity> getAllFood();
	
    
}
