package org.example;

public class Course {
    private final String name;
    private final int credits;
    private final String grade;

    public Course(String name, int credits, String grade) {
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Grade related functions
    // 1. getting grade
    // 2. getting weighted grade
    // 3. getting credits
    public double getGrade() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
                break;
        }
        return grade;
    }

    public int getCredits() {
        return this.credits;
    }

    public double getWeightedGrade() {
        return this.getCredits()*this.getGrade();
    }
}
