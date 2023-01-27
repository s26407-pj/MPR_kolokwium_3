package pl.pjatk.shopee_s26407;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootApplication
public class ShopServiceMockTest {

    @InjectMocks
    private ShopService shopService;

    @Mock
    private ShopStorage shopStorage;

    @Test
    public void itemListShouldNotBeEmpty() {
        Items items = new Items("whiskey", 50);

        when(shopStorage.getItemsList()).thenReturn(List.of(items));
        assertThat(shopService.getItems()).isNotEmpty();
    }
}