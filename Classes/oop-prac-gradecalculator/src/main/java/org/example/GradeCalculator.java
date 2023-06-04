package org.example;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;



    public GradeCalculator(List<Course> courseList) {
        this.courses = new Courses(courseList);
    }

    /**
     * Grade Calculator - AVG. GRADE = (Credits*Score)/Total Credits
     * First Class Collections
     **/
    public double calculateGrade() {
        double weightedGrades = courses.weightedGrades();
        int totalCredits = courses.totalCredits();
        return weightedGrades / totalCredits;
    }
}
