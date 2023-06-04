package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CustomerTest {
    @DisplayName("Ordering")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("Pork something", 5000), new MenuItem("Dumpling", 5000)));
        Cooking cooking = new Cooking();

        assertThatCode(()->customer.order("Dumpling", menu, cooking))
                .doesNotThrowAnyException();
    }
}
