/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpdao6;

import DaoImp.CourseImpDao;
import DaoImp.ResultImpDao;
import DaoImp.StudentImpDao;
import java.util.List;
import java.util.Scanner;
import model.Course;
import model.Student;
import model.Result;

/**
 *
 * @author Aline
 */
public class TPDao6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create Main Menu
        Scanner sc = new Scanner(System.in);
        StudentImpDao daoStudent = new StudentImpDao();
        CourseImpDao daoCourse = new CourseImpDao();
        ResultImpDao daoResult = new ResultImpDao();
        String keyreturnMain = "y";
        while (keyreturnMain.equalsIgnoreCase("y")) {
            mainMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    String keyreturnStu = "y";
                    while (keyreturnStu.equalsIgnoreCase("y")) {
                        subMenu("Student");
                        int choiceS = sc.nextInt();
                        switch (choiceS) {
                            case 1: {
                                daoStudent.create();
                                keyreturnStu = returnSubMenu("Student");
                                break;
                            }

                            case 2: {
                                daoStudent.delete(daoStudent.findAll(), daoResult.findAll());
                                keyreturnStu = returnSubMenu("Student");
                                break;
                            }

                            case 3: {
                                List<Student> liste = daoStudent.findAll();
                                System.out.println("--------------------------------------------------");
                                System.out.println("There are " + liste.size() + " students in total.");
                                System.out.println("--------------------------------------------------");
                                for (Student s : liste) {
                                    System.out.println("Student id: " + s.getId() + "  " + "First Name: " + s.getFirstName() + "  " + "Last Name: " + s.getLastName() + "  " + "Gender: " + s.getGender());
                                }
                                System.out.println("--------------------------------------------------");
                                keyreturnStu = returnSubMenu("Student");
                                break;
                            }

                            case 4: {
                                daoStudent.search();
                                keyreturnStu = returnSubMenu("Student");
                                break;
                            }

                            case 5: {
                                daoStudent.modify();
                                keyreturnStu = returnSubMenu("Student");
                                break;
                            }

                            case 6: {
                                System.out.println("You are leaving this student system.");
                                keyreturnStu = "n";
                                keyreturnMain = returnMainMenu();
                                break;
                            }

                            default: {
                                System.out.println("Input number is wrong, please choose the number again");
                                keyreturnStu = returnSubMenu("Student");
                                break;
                            }
                        }

                    }
                    break;
                }

                case 2: {
                    String keyreturnCour = "y";
                    while (keyreturnCour.equalsIgnoreCase("y")) {
                        subMenu("Course");
                        int choiceC = sc.nextInt();
                        switch (choiceC) {
                            case 1: {
                                daoCourse.create();
                                keyreturnCour = returnSubMenu("Course");
                                break;
                            }

                            case 2: {
                                daoCourse.delete(daoCourse.findAll(), daoResult.findAll());
                                keyreturnCour = returnSubMenu("Course");
                                break;
                            }

                            case 3: {
                                List<Course> listc = daoCourse.findAll();
                                System.out.println("There are " + listc.size() + " courses in total.");
                                System.out.println("------------------------------------------------------");
                                for (Course c : listc) {
                                    System.out.println("Course No.: " + c.getNo() + "  " + "Course Name: " + c.getCourseName());
                                }
                                System.out.println("------------------------------------------------------");
                                keyreturnCour = returnSubMenu("Course");
                                break;
                            }

                            case 4: {
                                daoCourse.search();
                                keyreturnCour = returnSubMenu("Course");
                                break;
                            }

                            case 5: {
                                daoCourse.modify();
                                keyreturnCour = returnSubMenu("Course");
                                break;
                            }

                            case 6: {
                                System.out.println("You are leaving the course system.");
                                keyreturnCour = "n";
                                keyreturnMain = returnMainMenu();
                                break;
                            }

                            default: {
                                System.out.println("Input number is wrong, please choose the number again");
                                keyreturnCour = returnSubMenu("Course");
                                break;
                            }
                        }

                    }
                    break;
                }

                case 3: {

                    String keyreturnRes = "y";
                    while (keyreturnRes.equalsIgnoreCase("y")) {
                        subMenu("Result");
                        int choiceR = sc.nextInt();
                        switch (choiceR) {
                            case 1: {
                                daoResult.create(daoStudent.findAll(), daoCourse.findAll());
                                keyreturnRes = returnSubMenu("Result");
                                break;
                            }
                            case 2: {
                                daoResult.delete(daoStudent.findAll(),daoCourse.findAll());
                                keyreturnRes = returnSubMenu("Result");
                                break;
                            }

                            case 3: {
                                List<Result> listr = daoResult.findAll();
                                System.out.println("There are " + listr.size() + " result in total.");
                                System.out.println("------------------------------------------------------");
                                for (Result r : listr) {
                                    System.out.println("Student ID. " + r.getStudent().getId() + "  " + "Student Name: " + r.getStudent().getFirstName() + "  " + r.getStudent().getLastName() + "  " + "Gender: " + r.getStudent().getGender() + "  " + "Course No. " + r.getCourse().getNo() + "  " + "Course name: " + r.getCourse().getCourseName() + "  " + "Mark 1: " + r.getMarks1() + "  " + "Mark 2: " + r.getMarks2());
                                }
                                System.out.println("------------------------------------------------------");
                                keyreturnRes = returnSubMenu("Result");
                                break;
                            }

                            case 4: {
                                daoResult.search();
                                keyreturnRes = returnSubMenu("Result");
                                break;
                            }

                            case 5: {
                                daoResult.modify();
                                keyreturnRes = returnSubMenu("Result");
                                break;
                            }

                            case 6: {
                                System.out.println("You are leaving this result system.");
                                keyreturnRes = "n";
                                keyreturnMain = returnMainMenu();
                                break;
                            }

                            default: {
                                System.out.println("Input number is wrong, please choose the number again");
                                keyreturnRes = returnSubMenu("Result");
                                break;
                            }
                        }

                    }
                    break;
                }

                case 4: {
                    System.out.println("You are leaving our school system.");
                    System.out.println("Thank you!");
                    keyreturnMain = "n";
                    break;
                }

                default: {
                    System.out.println("Input number is wrong, please choose the number again");
                    keyreturnMain = returnMainMenu();
                    break;
                }

            }

        }

    }

    public static void mainMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome to our school management system");
        System.out.println("1. Student");
        System.out.println("2. Course");
        System.out.println("3. Result");
        System.out.println("4. Exit");
        System.out.println("------------------------------------------------------");
        System.out.println("Please choose the number: ");
    }

    public static void subMenu(String system) {
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome to " + system + " management system");
        System.out.println("1. Create/add one " + system + " info ");
        System.out.println("2. Delete one " + system + " info ");
        System.out.println("3. Display all the infomation of " + system + "");
        System.out.println("4. Search one " + system + " info ");
        System.out.println("5. Modify one " + system + " info ");
        System.out.println("6. Exit");
        System.out.println("------------------------------------------------------");
        System.out.println("Please choose the function number: ");
    }

    public static String returnMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press <Enter> to return to the main menu");
        sc.nextLine();
        return "y";
    }

    public static String returnSubMenu(String system) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press <Enter> to return to the " + system + " menu.");
        sc.nextLine();
        return "y";
    }
    
           
 }
