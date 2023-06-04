package org.example;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courseList) {
        this.courses = courseList;
    }

    /**
     * Grade Calculator - AVG. GRADE = (Credits*Score)/Total Credits
     * First Class Collections
     **/
    public double calculateGrade() {
        double weightedGrade = 0;
        int totalCredits = courses.stream()
                .mapToInt(Course::getCredits)
                .sum();
        for (Course course : courses) {
            weightedGrade = course.getGrade() * course.getCredits();
            // totalCredits += course.getCredits();
        }

        return weightedGrade / totalCredits;
    }
}
