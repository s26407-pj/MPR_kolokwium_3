package pl.pjatk.shopee_s26407;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ShopIntegrationTest {

    @MockBean
    private ShopStorage shopStorage;

    @Autowired
    private ShopService shopService;

    @Test
    public void itemListShouldNotBeEmpty() {
        Items items = new Items("whiskey", 50);

        when(shopStorage.getItemsList()).thenReturn(List.of(items));
        assertThat(shopService.getItems()).isNotEmpty();
    }
}
