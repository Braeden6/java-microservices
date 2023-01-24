package spring.boot.assessment.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableFeignClients(clients = {CustomerProxy.class})
@EnableDiscoveryClient
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}

}
