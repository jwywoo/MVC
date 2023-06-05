package org.example;

import java.util.List;

public class Courses {
    private final List<Course> courseList;

    public Courses(List<Course> courseList) {
        this.courseList = courseList;
    }


    public double getWeightedTotal() {
        return courseList.stream()
                .mapToDouble(Course::getWeightedGrade)
                .sum();
    }

    public int getTotalCredits() {
        return courseList.stream()
                .mapToInt(Course::getCredits)
                .sum();
    }
}
