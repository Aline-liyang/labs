/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;
import model.Course;
import model.Result;

/**
 *
 * @author Aline
 */
public interface InterfaceCourse {

    void create();

    void delete(List<Course> listCourse, List<Result> listResult);

    List<Course> findAll();

    void modify();

    void search();

}
