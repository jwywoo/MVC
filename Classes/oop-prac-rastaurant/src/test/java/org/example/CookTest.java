package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CookTest {
    @DisplayName("Creating cook instance")
    @Test
    void createTest(){
        assertThatCode(() -> new Cook("Dumpling", 5000))
                .doesNotThrowAnyException();
    }
}
