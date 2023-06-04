package org.example;

public class Course {
    private final String subject;
    private final int credit;
    private final String grade;
    public Course(String subject, int credit, String grade){
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;

    }

    public double weightedGrade() {
        return this.getGrade()*this.credit;
    }

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
        return credit;
    }
}
