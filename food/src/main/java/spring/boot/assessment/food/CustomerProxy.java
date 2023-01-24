package spring.boot.assessment.food;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="customer-service")
public interface CustomerProxy {

	@GetMapping("/getCustomer")
	public List<CustomerEntity> getAllCustomers();

	@GetMapping("/getTopFood/{amount}")
	public List<FoodEntity> getTopFood(
		@PathVariable("amount") int amount);
	
    
}
