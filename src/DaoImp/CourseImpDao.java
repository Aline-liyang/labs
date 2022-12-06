/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Interface.InterfaceCourse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Course;
import model.Result;

/**
 *
 * @author Aline
 */
public class CourseImpDao implements InterfaceCourse {

    Scanner sc = new Scanner(System.in);
    private List<Course> listCourse;

    public CourseImpDao() {
        listCourse = new ArrayList<Course>();
    }

    public void create() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            Course cour = new Course();
            System.out.println("Input the course No.: ");
            cour.setNo(sc.nextDouble());
            System.out.println("Input the course name: ");
            cour.setCourseName(sc.next());
            listCourse.add(cour);
            System.out.println("could you want to add another course? y/n");
            returnkey = sc.next();
        }
        System.out.println("-------------------------------------------");
    }

    public List<Course> findAll() {
        return listCourse;
    }

    public void search() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            int index = searchCoursePosition();
            if (index >= 0) {
                System.out.println("The info of this course is found.");
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Course No.: " + listCourse.get(index).getNo() + "  " + "Course name: " + listCourse.get(index).getCourseName());
            } else {
                System.out.println("Error: Input is wrong! please check your intput.");
            }
            System.out.println("could you want to search another course? y/n");
            returnkey = sc.next();
        }
    }

    public void modify() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) { 
            int index = searchCoursePosition();
            if (index >= 0) {
                System.out.println("The info of this course is found.");
                System.out.println("Course No.: " + listCourse.get(index).getNo() + "  " + "Course name: " + listCourse.get(index).getCourseName());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("please modify the info of this course: ");
                System.out.println("Input the course No.: ");
                listCourse.get(index).setNo(sc.nextDouble());
                System.out.println("Input the course name: ");
                listCourse.get(index).setCourseName(sc.next());
                System.out.println("The info of this course is modified!");
                System.out.println("---------------------------------------------------------------------------------------------------------------");
                System.out.println("Course No.: " + listCourse.get(index).getNo() + "  " + "Course name: " + listCourse.get(index).getCourseName());
                System.out.println("---------------------------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Error: Input is wrong! please check your intput.");
            }
            System.out.println("could you want to modify another course? y/n");
            returnkey = sc.next();
        }
    }

    public void delete(List<Course> listCourse, List<Result> listResult) {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            System.out.println("There are " + listCourse.size() + " courses in total.");
            System.out.println("-------------------------------------------------------------------");
            int index = searchCoursePosition();
            if (index >= 0) {
                System.out.println("The info of this course is found.");
                System.out.println("Course No.: " + listCourse.get(index).getNo() + "  " + "Course name: " + listCourse.get(index).getCourseName());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Are you sure to delete it?(y/n)");
                String dlchoice = sc.next();
                double dlcourseno = 0;
                String dlcoursename = "";
                if (dlchoice.equalsIgnoreCase("y")) {
                    dlcourseno = listCourse.get(index).getNo();
                    dlcoursename = listCourse.get(index).getCourseName();
                    listCourse.remove(index);
                    if (listResult.size() != 0) {
                        for (int j = listResult.size() - 1; j >= 0; j--) {
                            if (listResult.get(j).getCourse().getNo() == dlcourseno) {
                                listResult.remove(j);
                            }
                        }
                    }
                }
                int newsize = listCourse.size();
                if (newsize == 0) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Now no course left, this course list is empty.");
                    System.out.println("The course No.: " + dlcourseno + " " + " Course Name: " + dlcoursename + " is deleted.");

                } else {
                    Boolean var = true;
                    for (int i = 0; i < newsize; i++) {
                        if (listCourse.get(i).getNo() == dlcourseno) {
                            System.out.println("Error: the course info isn't deleted.");
                            var = false;
                            break;
                        }
                    }
                    if (var) {
                        System.out.println("Now there are " + newsize + " courses left.");
                        System.out.println("The course No.: " + dlcourseno + " " + " Course Name: " + dlcoursename + " is deleted.");
                    }
                }
            } else {
                System.out.println("Error: Input is wrong! please check your intput.");
            }
            System.out.println("could you want to delete another course? y/n");
            returnkey = sc.next();
        }
    }

    private int searchCoursePosition() {
        int pos = -1;
        if (listCourse.isEmpty()) {
            System.out.println("This course list is empty.");
        } else {
            System.out.println("Would you like to search the course by: ");
            System.out.println("1. Course No.");
            System.out.println("2. Course name");
            System.out.println("please enter your choice.(1/2)");
            int searchchoice = sc.nextInt();
            switch (searchchoice) {
                case 1: {
                    System.out.println("please enter the course No.: ");
                    double no = sc.nextDouble();
                    for (int i = 0; i < listCourse.size(); i++) {
                        if (listCourse.get(i).getNo() == no) {
                            pos = i;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("please enter the course Name: ");
                    String name = sc.next();
                    for (int i = 0; i < listCourse.size(); i++) {
                        if (listCourse.get(i).getCourseName().equalsIgnoreCase(name)) {
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
