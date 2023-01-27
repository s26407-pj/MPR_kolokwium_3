package pl.pjatk.shopee_s26407;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopService {

    private final ShopStorage shopStorage;

    public ShopService(ShopStorage shopStorage) {
        this.shopStorage = shopStorage;
    }

    public void orderItems(Cart cart) {

        Customer customer = cart.getCustomer();
        double customerBalance = cart.getCustomer().getBalance();
        double shoppingSum = 0.0;

        List<Items> shopItems = shopStorage.getItemsList();
        List<String> cartItems = cart.getCarItems();

        for(String itemInCart : cartItems) {
            for(Items itemInShop : shopItems) {
                if(itemInCart.equals(itemInShop.getItemName())) {
                    shoppingSum += itemInShop.getItemPrice();
                    System.out.println(itemInCart + " cena: " + itemInShop.getItemPrice());
                }
            }
        }

        if(customerBalance >= shoppingSum) {
            double saldo = customerBalance - shoppingSum;
            customer.setBalance(saldo);
            System.out.println("Transakcja zaakceptowana. Cena zakupów: " + shoppingSum + ", pozostałe saldo: " + saldo);
        }
    }

    public List<Items> getItems()
    {
        return shopStorage.getItemsList();
    }
}
