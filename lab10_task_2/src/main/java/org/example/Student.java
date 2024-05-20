package org.example;

import java.util.List;

public class Student {
    private String name;
    private String major;
    private List<Course> courses;

    public Student() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Calculating average grade
    public double calculateAverageGrade() {
        return courses.stream().mapToDouble(Course::getCourseGrade).average().orElse(0.0);
    }
}
