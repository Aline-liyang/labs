/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aline
 */
public class Result {
    private Student student;
    private Course course;
    private double marks1;
    private double marks2;

    public Result() {
    }

    public Result(Student student, Course course, double marks1, double marks2) {
        this.student = student;
        this.course = course;
        this.marks1 = marks1;
        this.marks2 = marks2;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getMarks1() {
        return marks1;
    }

    public void setMarks1(double marks1) {
        this.marks1 = marks1;
    }

    public double getMarks2() {
        return marks2;
    }

    public void setMarks2(double marks2) {
        this.marks2 = marks2;
    }
    
    
            
    
}
