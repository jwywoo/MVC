package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;


public class CourseTest {

    @DisplayName("Creating a test")
    @Test
    void createTest() {
        assertThatCode(()-> new Course("oop", 3, "A+"))
                .doesNotThrowAnyException();
    }
}
