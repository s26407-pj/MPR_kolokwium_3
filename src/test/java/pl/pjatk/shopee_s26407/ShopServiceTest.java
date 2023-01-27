package pl.pjatk.shopee_s26407;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
public class ShopServiceTest {

    private ShopStorage shopStorage = new ShopStorage();

    @Test
    public void balanceShouldChange() {
        ShopService shopService = new ShopService(shopStorage);
        Customer customer = new Customer(1, 100);
        Cart cart = new Cart(customer);
        cart.addItemToCar("milk");

        double balance = customer.getBalance();
        shopService.orderItems(cart);
        double newBalance = customer.getBalance();

        assertThat(balance).isNotEqualTo(newBalance);
    }

    @Test
    public void balanceShouldNotChange_notEnoughMoney() {
        ShopService shopService = new ShopService(shopStorage);
        Customer customer = new Customer(1, 10);
        Cart cart = new Cart(customer);
        cart.addItemToCar("wine");

        double balance = customer.getBalance();
        shopService.orderItems(cart);
        double newBalance = customer.getBalance();

        assertThat(balance).isEqualTo(newBalance);
    }
}