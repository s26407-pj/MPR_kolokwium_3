package pl.pjatk.shopee_s26407;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private Customer customer;

    private List<String> carItems = new ArrayList<>();

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public void addItemToCar(String itemName) {
        carItems.add(itemName);
    }

    public List<String> getCarItems() {
        return carItems;
    }

    public Customer getCustomer() {
        return customer;
    }
}
