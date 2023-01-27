package pl.pjatk.shopee_s26407;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopStorage {

    private List<Items> itemList = new ArrayList<>();

    public ShopStorage() {
        itemList.add(new Items("milk", 10));
        itemList.add(new Items("beer", 15));
        itemList.add(new Items("water", 5));
        itemList.add(new Items("wine", 25));
    }

    public List<Items> getItemsList() {
        return itemList;
    }
}