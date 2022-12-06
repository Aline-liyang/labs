/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;
import model.Result;
import model.Student;

/**
 *
 * @author Aline
 */
public interface InterfaceStudent {

    void create();

    void delete(List<Student> listStudent, List<Result> listResult);

    void search();

    List<Student> findAll();

    void modify();

}
