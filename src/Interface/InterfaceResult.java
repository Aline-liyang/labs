/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;
import model.Course;
import model.Result;
import model.Student;

/**
 *
 * @author Aline
 */
public interface InterfaceResult {

    void create(List<Student> liststudent,List<Course> listcourse);

    List<Result> findAll();

    void search();

    void delete(List<Student> liststudent,List<Course> listcourse);

    void modify();

}
