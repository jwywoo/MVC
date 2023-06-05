package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courseList;

    public GradeCalculator(List<Course> courseList) {
        this.courseList = new Courses(courseList);
    }

    public double calculateGrade() {
        return courseList.getWeightedTotal()/courseList.getTotalCredits();
    }
}
