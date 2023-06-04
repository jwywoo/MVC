package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {
    @DisplayName("Creating instance of cooking")
    @Test
    void createTest() {
        Cooking chief = new Cooking();
        MenuItem menuItem = new MenuItem("Pork something", 5000);

        Cook preparedItem = chief.cookingMenuItem(menuItem);

        assertThat(preparedItem).isEqualTo(new Cook("Pork something", 5000));
    }
}
