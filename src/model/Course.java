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
public class Course {
    private double No;
    private String courseName;

    public Course() {
    }

    public Course(double No, String courseName) {
        this.No = No;
        this.courseName = courseName;
    }

    public double getNo() {
        return No;
    }

    public void setNo(double No) {
        this.No = No;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    
    
}
