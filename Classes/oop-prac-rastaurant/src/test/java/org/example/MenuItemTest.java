package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class MenuItemTest {
    @DisplayName("Creating menu list")
    @Test
    void createTest() {
        assertThatCode(() -> new MenuItem("Dumpling", 5000))
                .doesNotThrowAnyException();
    }

}
