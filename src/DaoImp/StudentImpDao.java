/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Interface.InterfaceStudent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Result;
import model.Student;

/**
 *
 * @author Aline
 */
public class StudentImpDao implements InterfaceStudent {

    Scanner sc = new Scanner(System.in);
    private List<Student> listStudent;

    public StudentImpDao() {
        listStudent = new ArrayList<Student>();
    }

    public void create() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            Student stu = new Student();
            System.out.println("Input the student's ID: ");
            stu.setId(sc.nextInt());
            System.out.println("Input the student's first name: ");
            stu.setFirstName(sc.next());
            System.out.println("Input the student's last name: ");
            stu.setLastName(sc.next());
            System.out.println("Input the student's gender: ");
            stu.setGender(sc.next());
            listStudent.add(stu);
            System.out.println("could you want to add another student? y/n");
            returnkey = sc.next();
        }
        System.out.println("-------------------------------------------");
    }

    public List<Student> findAll() {
        return listStudent;
    }

    public void delete(List<Student> listStudent, List<Result> listResult) {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            System.out.println("-------------------------------------------------------");
            System.out.println("There are " + listStudent.size() + " students in total.");
            System.out.println("-------------------------------------------------------");
            int index = searchStudentPosition();
            if (index >= 0) {
                System.out.println("The info of this student is found.");
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Student id.: " + listStudent.get(index).getId() + "  " + "Student name: " + listStudent.get(index).getFirstName() + " " + listStudent.get(index).getLastName() + "  " + "Gender: " + listStudent.get(index).getGender());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Are you sure to delete it?(y/n)");
                String dlchoice = sc.next();
                int dlstudentid = listStudent.get(index).getId();
                String dlstudentfirstname = listStudent.get(index).getFirstName();
                String dlstudentlastname = listStudent.get(index).getLastName();
                String dlstudentgender = listStudent.get(index).getGender();
                if (dlchoice.equalsIgnoreCase("y")) {
                    listStudent.remove(index);
                    if (listResult.size() != 0) {
                        for (int j = listResult.size() - 1; j >= 0; j--) {
                            if (listResult.get(j).getStudent().getId() == dlstudentid) {
                                listResult.remove(j);
                            }
                        }
                    }
                }
                int newsize = listStudent.size();
                if (newsize == 0) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Now no student left, this student list is empty.");
                    System.out.println("Student id.: " + dlstudentid + "  " + "Student name: " + dlstudentfirstname + " " + dlstudentlastname + "  " + "Gender: " + dlstudentgender + " is deleted.");

                } else {
                    Boolean var = true;
                    for (int i = 0; i < newsize; i++) {
                        if (listStudent.get(i).getId() == dlstudentid) {
                            System.out.println("Error: the student info isn't deleted.");
                            var = false;
                            break;
                        }
                    }
                    if (var) {
                        System.out.println("Now there are " + newsize + " courses left.");
                        System.out.println("Student id.: " + dlstudentid + "  " + "Student name: " + dlstudentfirstname + " " + dlstudentlastname + "  " + "Gender: " + dlstudentgender + " is deleted.");
                    }
                }
            } else {
                System.out.println("Error: Input is wrong! please check your intput.");
            }
            System.out.println("could you want to delete another student? y/n");
            returnkey = sc.next();
        }
    }

    
    public void search() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            int index = searchStudentPosition();
            if (index >= 0) {
                System.out.println("The info of this student is found.");
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Student id.: " + listStudent.get(index).getId() + "  " + "Student name: " + listStudent.get(index).getFirstName() + " " + listStudent.get(index).getLastName() + "  " + "Gender: " + listStudent.get(index).getGender());
            } else {
                System.out.println("Error: Input is wrong! please check your intput.");
            }
            System.out.println("could you want to search another student? y/n");
            returnkey = sc.next();
        }
    }

    
    public void modify() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            int index = searchStudentPosition();
            if (index >= 0) {
                System.out.println("The info of this student is found.");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Student id.: " + listStudent.get(index).getId() + "  " + "Student name: " + listStudent.get(index).getFirstName() + " " + listStudent.get(index).getLastName() + "  " + "Gender: " + listStudent.get(index).getGender());
                System.out.println("please modify the info of this student: ");
                System.out.println("Input the Student id.: ");
                listStudent.get(index).setId(sc.nextInt());
                System.out.println("Input the student firstname: ");
                listStudent.get(index).setFirstName(sc.next());
                System.out.println("Input the student lastname: ");
                listStudent.get(index).setLastName(sc.next());
                System.out.println("Input the student gender: ");
                listStudent.get(index).setGender(sc.next());
                System.out.println("The info of this course is modified!");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Student id.: " + listStudent.get(index).getId() + "  " + "Student name: " + listStudent.get(index).getFirstName() + " " + listStudent.get(index).getLastName() + "  " + "Gender: " + listStudent.get(index).getGender());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Error: Input is wrong! please check your intput.");
            }
            System.out.println("could you want to modify another student? y/n");
            returnkey = sc.next();
        }
    }

    private int searchStudentPosition() {
        int pos = -1;
        if (listStudent.isEmpty()) {
            System.out.println("This student list is empty.");
        } else {
            System.out.println("Would you like to search the student by: ");
            System.out.println("1. Student ID.");
            System.out.println("2. Student name");
            System.out.println("please enter your choice.(1/2)");
            int searchchoice = sc.nextInt();
            switch (searchchoice) {
                case 1: {
                    System.out.println("please enter the student ID.: ");
                    int id = sc.nextInt();
                    for (int i = 0; i < listStudent.size(); i++) {
                        if (listStudent.get(i).getId() == id) {
                            pos = i;
                            break;
                        }
                    }
                    break;
                }

                case 2: {
                    System.out.println("please enter the student name: ");
                    System.out.println("First name: ");
                    String fname = sc.next();
                    System.out.println("Last name: ");
                    String lname = sc.next();
                    for (int i = 0; i < listStudent.size(); i++) {
                        if (listStudent.get(i).getFirstName().equalsIgnoreCase(fname) && listStudent.get(i).getLastName().equalsIgnoreCase(lname)) {
                            pos = i;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return pos;
    }

}
