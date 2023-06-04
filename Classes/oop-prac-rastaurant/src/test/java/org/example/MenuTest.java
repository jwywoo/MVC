package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
public class MenuTest {
    @DisplayName("Choosing menu test")
    @Test
    void menuChooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("Pork something", 5000), new MenuItem("Dumpling", 5000)));

        MenuItem menuItem = menu.choose("Pork something");

        assertThat(menuItem).isEqualTo(new MenuItem("Pork something", 5000));
    }

    @DisplayName("Choosing not available menu item from menu")
    @Test
    void notAvailableMenuItem() {
        Menu menu = new Menu(List.of(new MenuItem("Pork something", 5000), new MenuItem("Dumpling", 5000)));
        assertThatCode(() -> menu.choose("Not pork"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("N/A menu item");
    }
}
