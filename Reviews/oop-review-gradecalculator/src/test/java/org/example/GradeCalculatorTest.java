package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GradeCalculatorTest {
    @DisplayName("Checking the functionality of grade")
    @Test
    void calculationTest() {
        // Create list of courses
        List<Course> courseList = List.of(
                new Course("OOP", 3, "A+"),
                new Course("Data Structure", 3, "A+")
        );

        // Calculate the grade
        GradeCalculator gradeCalculator = new GradeCalculator(courseList);
        double calculatedGrade = gradeCalculator.calculateGrade();

        assertThat(calculatedGrade).isEqualTo(4.5);
    }
}
