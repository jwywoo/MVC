package org.example;

import java.util.List;

public class Courses {
    private final List<Course> courses;
    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double weightedGrades() {
        return courses.stream()
                .mapToDouble(Course::weightedGrade)
                .sum();
    }

    public int totalCredits() {
        return courses.stream()
                .mapToInt(Course::getCredits)
                .sum();
    }
}
