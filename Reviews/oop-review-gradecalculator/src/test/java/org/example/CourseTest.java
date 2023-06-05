package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {
    @DisplayName("Whether the course is created or not")
    @Test
    void createCourseTest() {
        assertThatCode(()->new Course("OOP",3,"A+"))
                .doesNotThrowAnyException();
    }
}
