package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Grade Calculator - AVG. GRADE = (Credits*Score)/Total Credits
 * First Class Collections
 * **/
public class GradeCalculatorTest {
    @DisplayName("Returning AVG grade")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(
                new Course("OOP", 3,"A+"),
                new Course("DataStructure",3,"A+")
//                new Course("TestCourse", 3,"A+"),
//                new Course("TestCourse1", 4, "A+")
                );

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double calculatedGrade = gradeCalculator.calculateGrade();

        assertThat(calculatedGrade).isEqualTo(4.5);
    }
}
