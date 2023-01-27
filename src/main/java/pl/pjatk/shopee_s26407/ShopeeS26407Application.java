package pl.pjatk.shopee_s26407;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopeeS26407Application {

	private final ShopService shopService;

	public ShopeeS26407Application(ShopService shopService) {
		this.shopService = shopService;

		Customer customer = new Customer(1, 100);
		Cart cart = new Cart(customer);
		cart.addItemToCar("milk");
		cart.addItemToCar("milk");
		cart.addItemToCar("beer");
		shopService.orderItems(cart);

	}

	public static void main(String[] args) {
		SpringApplication.run(ShopeeS26407Application.class, args);
	}

}
