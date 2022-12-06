/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Interface.InterfaceResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Course;
import model.Result;
import model.Student;

/**
 *
 * @author Aline
 */
public class ResultImpDao implements InterfaceResult {

    Scanner sc = new Scanner(System.in);
    private List<Result> listResult;

    public ResultImpDao() {
        listResult = new ArrayList<Result>();
    }

    public void create(List<Student> liststudent, List<Course> listcourse) {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            System.out.println("What course result list do you want to create? ");
            System.out.println("Please <Enter -1 > for choosing the course NO. as input. or  <Enter -2 > for choosing the course name.");
            int inputnum = sc.nextInt();
            int index = 0;
            //Boolean cvar = false;
            switch (inputnum) {
                case 1: {
                    System.out.println("Please input the course NO. :  ");
                    double courseno = sc.nextDouble();
                    Boolean var = true;
                    for (int i = 0; i < listcourse.size(); i++) {
                        if (listcourse.get(i).getNo() == courseno) {
                            index = i;
                            System.out.println(" Please enter the " + listcourse.get(i).getCourseName() + " marks of all students: ");
                            for (int j = 0; j < liststudent.size(); j++) {
                                Result res = new Result();
                                res.setStudent(liststudent.get(j));
                                res.setCourse(listcourse.get(index));
                                System.out.println("please input " + liststudent.get(j).getFirstName() + " " + liststudent.get(j).getLastName() + " marks");
                                System.out.println("Input the first mark: ");
                                double mark1 = sc.nextDouble();
                                res.setMarks1(mark1);
                                System.out.println("Input the second mark: ");
                                double mark2 = sc.nextDouble();
                                res.setMarks2(mark2);
                                listResult.add(res);
                            }
                            var = false;
                            break;
                        }
                    }
                    if (var) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Error: Input is wrong! please check your input.");
                        System.out.println("--------------------------------------------------");
                    }
                    break;
                }
                
                case 2: {
                    System.out.println("Please input the course name. :  ");
                    String coursename = sc.next();
                    Boolean var = true;
                    for (int i = 0; i < listcourse.size(); i++) {
                        if (listcourse.get(i).getCourseName().equalsIgnoreCase(coursename)) {
                            index = i;
                            System.out.println(" Please enter the " + coursename + " marks of all students: ");
                            for (int j = 0; j < liststudent.size(); j++) {
                                Result res = new Result();
                                res.setStudent(liststudent.get(j));
                                res.setCourse(listcourse.get(index));
                                System.out.println("please input " + liststudent.get(j).getFirstName() + " " + liststudent.get(j).getLastName() + " marks");
                                System.out.println("Input the first mark: ");
                                double mark1 = sc.nextDouble();
                                res.setMarks1(mark1);
                                System.out.println("Input the second mark: ");
                                double mark2 = sc.nextDouble();
                                res.setMarks2(mark2);
                                listResult.add(res);
                            }
                            var = false;
                            break;
                        }
                    }
                    if (var) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Error: Input is wrong! please check your input.");
                        System.out.println("--------------------------------------------------");
                    }
                    break;
                }
                
                default: {
                    Boolean var = true;
                    if (var) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Error: Input is wrong! please check your input.");
                        System.out.println("--------------------------------------------------");
                    }
                    break;
                }
            }
            System.out.println("could you want to add another course result? y/n");
            returnkey = sc.next();
        }
        System.out.println("-------------------------------------------");
    }

    public List<Result> findAll() {
        return listResult;
    }

    public void modify() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            System.out.println("Would you like to update the result by: ");
            System.out.println("1. Student ");
            System.out.println("2. Course ");
            System.out.println("please enter your choice.");
            int modifychoice = sc.nextInt();
            switch (modifychoice) {
                case 1: {
                    List<Integer> searchstupos = searchResultStudentPosition();
                    if (searchstupos.size() != 0) {
                        System.out.println("which course mark do you want to update?/please input the course No. ");
                        double modcourseno = sc.nextDouble();
                        Boolean var1 = true;
                        for (int i = 0; i < searchstupos.size(); i++) {
                            int searchindex = (int) searchstupos.get(i);
                            if (listResult.get(searchindex).getCourse().getNo() == modcourseno) {
                                System.out.println("Display the mark of this student");
                                System.out.println("Student id: " + listResult.get(searchindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchindex).getStudent().getFirstName() + " " + listResult.get(searchindex).getStudent().getLastName());
                                System.out.println("Course No.:" + listResult.get(searchindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchindex).getCourse().getCourseName());
                                System.out.println("Mark1: " + listResult.get(searchindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchindex).getMarks2());
                                System.out.println("------------------------------------------------------------");
                                System.out.println("update the mark1: ");
                                int updatemark1 = sc.nextInt();
                                System.out.println("update the mark2: ");
                                int updatemark2 = sc.nextInt();
                                listResult.get(searchindex).setMarks1(updatemark1);
                                listResult.get(searchindex).setMarks2(updatemark2);
                                System.out.println("This student is modified: ");
                                System.out.println("Student id: " + listResult.get(searchindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchindex).getStudent().getFirstName() + " " + listResult.get(searchindex).getStudent().getLastName());
                                System.out.println("Course No.:" + listResult.get(searchindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchindex).getCourse().getCourseName());
                                System.out.println("Mark1: " + listResult.get(searchindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchindex).getMarks2());
                                System.out.println("------------------------------------------------------------");
                                var1 = false;
                                break;
                            }
                        }
                        if (var1) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Error M1: Input is wrong! please check your input.");
                            System.out.println("--------------------------------------------------");
                        }
                    }
                    break;
                }

                case 2: {
                    List<Integer> searchcourpos = searchResultCoursePosition();
                    if (searchcourpos.size() != 0) {
                        System.out.println("Which student's marks will be update?");
                        System.out.println("Please input the student first name:  ");
                        String studentfname = sc.next();
                        System.out.println("Please input the student last name:  ");
                        String studentlname = sc.next();
                        Boolean var1 = true;
                        for (int i = 0; i < searchcourpos.size(); i++) {
                            int searchindex = (int) searchcourpos.get(i);
                            if ((listResult.get(searchindex).getStudent().getFirstName().equalsIgnoreCase(studentfname)) && (listResult.get(searchindex).getStudent().getLastName().equalsIgnoreCase(studentlname))) {
                                System.out.println("Display the  marks of this students");
                                System.out.println("Student id: " + listResult.get(searchindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchindex).getStudent().getFirstName() + " " + listResult.get(searchindex).getStudent().getLastName());
                                System.out.println("Course No.:" + listResult.get(searchindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchindex).getCourse().getCourseName());
                                System.out.println("Mark1: " + listResult.get(searchindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchindex).getMarks2());
                                System.out.println("------------------------------------------------------------");
                                System.out.println("update the mark1: ");
                                int updatemark1 = sc.nextInt();
                                System.out.println("update the mark2: ");
                                int updatemark2 = sc.nextInt();
                                listResult.get(searchindex).setMarks1(updatemark1);
                                listResult.get(searchindex).setMarks2(updatemark2);
                                System.out.println("This student is modified: ");
                                System.out.println("Student id: " + listResult.get(searchindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchindex).getStudent().getFirstName() + " " + listResult.get(searchindex).getStudent().getLastName());
                                System.out.println("Course No.:" + listResult.get(searchindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchindex).getCourse().getCourseName());
                                System.out.println("Mark1: " + listResult.get(searchindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchindex).getMarks2());
                                System.out.println("------------------------------------------------------------");
                                var1 = false;
                                break;
                            }
                        }
                        if (var1) {
                            System.out.println("--------------------------------------------------");
                            System.out.println("Error M2: Input is wrong! please check your input.");
                            System.out.println("--------------------------------------------------");
                        }
                    }
                    break;
                }
            }
            System.out.println("would you want to modify another result? y/n");
            returnkey = sc.next();
        }
    }

    public void search() {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            System.out.println("Would you like to search the result by: ");
            System.out.println("1. Student ");
            System.out.println("2. Course ");
            System.out.println("please enter your choice.");
            int searchchoice = sc.nextInt();
            switch (searchchoice) {
                case 1: {
                    List<Integer> searchstupos = searchResultStudentPosition();
                    System.out.println("There are " + searchstupos.size() + " marks records about this student.");
                    if (searchstupos.size() != 0) {
                        System.out.println("Display all courses' marks of this student");
                        System.out.println("---------------------------------------------------------------------------------");
                        for (int i = 0; i < searchstupos.size(); i++) {
                            int searchstuindex = searchstupos.get(i);
                            System.out.println("Student id: " + listResult.get(searchstuindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchstuindex).getStudent().getFirstName() + " " + listResult.get(searchstuindex).getStudent().getLastName());
                            System.out.println("Course No.:" + listResult.get(searchstuindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchstuindex).getCourse().getCourseName());
                            System.out.println("Mark1: " + listResult.get(searchstuindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchstuindex).getMarks2());
                        }
                    }
                    break;
                }
                case 2: {
                    List<Integer> searchcourpos = searchResultCoursePosition();
                    System.out.println("There are " + searchcourpos.size() + " marks records about this course.");
                    if (searchcourpos.size() != 0) {
                        System.out.println("Display this course marks of all students");
                        System.out.println("---------------------------------------------------------------------------------");
                        for (int i = 0; i < searchcourpos.size(); i++) {
                            int searchcourindex = searchcourpos.get(i);
                            System.out.println("Student id: " + listResult.get(searchcourindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchcourindex).getStudent().getFirstName() + " " + listResult.get(searchcourindex).getStudent().getLastName());
                            System.out.println("Course No.:" + listResult.get(searchcourindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchcourindex).getCourse().getCourseName());
                            System.out.println("Mark1: " + listResult.get(searchcourindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchcourindex).getMarks2());
                        }
                    }
                    break;
                }
            }
            System.out.println("Would you want to search another result? y/n");
            returnkey = sc.next();
        }
    }

    public void delete(List<Student> liststudent, List<Course> listcourse) {
        String returnkey = "y";
        while (returnkey.equalsIgnoreCase("y")) {
            System.out.println("Would you like to delete the result by: ");
            System.out.println("1. Student ");
            System.out.println("2. Course ");
            System.out.println("please enter your choice.");
            int deletechoice = sc.nextInt();
            switch (deletechoice) {
                case 1: {
                    List<Integer> searchstupos = searchResultStudentPosition();
                    System.out.println("--------------------------------------------------");
                    System.out.println("There are " + listResult.size() + " results in total.");
                    System.out.println("--------------------------------------------------");
                    if (searchstupos.size() != 0) {
                        Boolean dlvar = false;
                        System.out.println("which course mark do you want to delete?/please input the course No. ");
                        double dlcourseno = sc.nextDouble();
                        int dlindex = (int) searchstupos.get(0);
                        int dlid = listResult.get(dlindex).getStudent().getId();
                        for (int i = 0; i < searchstupos.size(); i++) {
                            int searchindex = (int) searchstupos.get(i);
                            if (listResult.get(searchindex).getCourse().getNo() == dlcourseno) {
                                System.out.println("Display the mark of this student");
                                System.out.println("Student id: " + listResult.get(searchindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchindex).getStudent().getFirstName() + " " + listResult.get(searchindex).getStudent().getLastName());
                                System.out.println("Course No.:" + listResult.get(searchindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchindex).getCourse().getCourseName());
                                System.out.println("Mark1: " + listResult.get(searchindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchindex).getMarks2());
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("Are you sure to delete it? (y/n)");
                                String reply = sc.next();
                                if (reply.equalsIgnoreCase("y")) {
                                    listResult.remove(searchindex);
                                    dlvar = true;
                                }
                                break;
                            }
                        }
                        int newsize = listResult.size();

                        if (newsize == 0) {
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println("There is no result left, the result list is empty.");
                            System.out.println("The result of this student ID: " + dlid + " Course NO.: " + dlcourseno + " is deleted.");
                            System.out.println("-------------------------------------------------------------------------");

                        } else {
                            Boolean var = true;
                            for (int i = 0; i < newsize; i++) {
                                if ((listResult.get(i).getStudent().getId() == dlid) && (listResult.get(i).getCourse().getNo() == dlcourseno)) {
                                    System.out.println("Error D1: the result's info isn't deleted.");
                                    var = false;
                                    break;
                                }
                            }
                            if (var && dlvar) {
                                System.out.println("----------------------------------------------------------------------------");
                                System.out.println("Now there are " + newsize + " results left.");
                                System.out.println("The result of this student ID: " + dlid + " Course NO.: " + dlcourseno + " is deleted.");
                                System.out.println("----------------------------------------------------------------------------");
                            }
                        }
                        if (!dlvar) {
                            System.out.println("-------------------------------------------------------");
                            System.out.println("Error D2: Course NO is wrong! please check your input.");
                            System.out.println("-------------------------------------------------------");
                        }
                    }
                    break;
                }

                case 2: {
                    List<Integer> searchcourpos = searchResultCoursePosition();
                    System.out.println("--------------------------------------------------");
                    System.out.println("There are " + listResult.size() + " results in total.");
                    System.out.println("--------------------------------------------------");
                    if (searchcourpos.size() != 0) {
                        Boolean dlvar = false;
                        System.out.println("Which student's marks will be deleted?");
                        System.out.println("Please input the student first name:  ");
                        String dlstudentfname = sc.next();
                        System.out.println("Please input the student last name:  ");
                        String dlstudentlname = sc.next();
                        int dlindex = (int) searchcourpos.get(0);
                        double dlcourseno = listResult.get(dlindex).getCourse().getNo();
                        for (int i = 0; i < searchcourpos.size(); i++) {
                            int searchindex = (int) searchcourpos.get(i);
                            if ((listResult.get(searchindex).getStudent().getFirstName().equalsIgnoreCase(dlstudentfname)) && (listResult.get(searchindex).getStudent().getLastName().equalsIgnoreCase(dlstudentlname))) {
                                System.out.println("Display the  marks of this students");
                                System.out.println("Student id: " + listResult.get(searchindex).getStudent().getId() + "  " + "Student name: " + listResult.get(searchindex).getStudent().getFirstName() + " " + listResult.get(searchindex).getStudent().getLastName());
                                System.out.println("Course No.:" + listResult.get(searchindex).getCourse().getNo() + "  " + "Course name: " + listResult.get(searchindex).getCourse().getCourseName());
                                System.out.println("Mark1: " + listResult.get(searchindex).getMarks1() + "  " + "Mark12: " + listResult.get(searchindex).getMarks2());
                                System.out.println("------------------------------------------------------------");
                                System.out.println("Are you sure to delete it? (y/n)");
                                String reply = sc.next();
                                if (reply.equalsIgnoreCase("y")) {
                                    listResult.remove(searchindex);
                                    dlvar = true;
                                }
                                break;

                            }
                        }
                        int newsize = listResult.size();

                        if (newsize == 0) {
                            System.out.println("-------------------------------------------------------------------------------------");
                            System.out.println("There is no result left, the result list is empty");
                            System.out.println("The result of this student name: " + dlstudentfname + " " + dlstudentlname + " " + " Course No. :" + dlcourseno + " is deleted.");
                            System.out.println("--------------------------------------------------------------------------------------");

                        } else {
                            Boolean var = true;
                            for (int i = 0; i < newsize; i++) {
                                if ((listResult.get(i).getCourse().getNo() == dlcourseno) && (listResult.get(i).getStudent().getFirstName().equalsIgnoreCase(dlstudentfname)) && (listResult.get(i).getStudent().getFirstName().equalsIgnoreCase(dlstudentfname))) {
                                    System.out.println("Error D3: the result's info isn't deleted.");
                                    var = false;
                                    break;
                                }
                            }
                            if (var && dlvar) {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("Now there are " + newsize + " results left.");
                                System.out.println("The result of this student name: " + dlstudentfname + " " + dlstudentlname + " " + " Course No. :" + dlcourseno + " is deleted.");
                                System.out.println("---------------------------------------------------------------------------------");
                            }
                        }
                        if (!dlvar) {
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Error D4: Student name is wrong! please check your input.");
                            System.out.println("----------------------------------------------------------------------");
                        }

                    }
                    break;
                }
            }
            System.out.println("could you want to delete another result? y/n");
            returnkey = sc.next();
        }
    }

    private List<Integer> searchResultStudentPosition() {
        List<Integer> stupos = new ArrayList();
        Boolean var = true;
        if (listResult.isEmpty()) {
            System.out.println("This result list is empty.");
            var = false;
        } else {
            System.out.println("please <Enter-1> for the student ID. or <Enter-2> for student name: ");
            int id = sc.nextInt();
            Boolean vars = false;
            switch (id) {
                case 1: {
                    System.out.println("Please input the student ID. :  ");
                    int studentid = sc.nextInt();

                    for (int i = 0; i < listResult.size(); i++) {
                        if (listResult.get(i).getStudent().getId() == studentid) {
                            stupos.add(i);
                            vars = true;
                            System.out.println("i: " + i);
                        }
                    }
                    System.out.println("size: " + stupos.size());
                    if ((!vars) && var) {
                        System.out.println("Error1 : Input student ID is wrong! please check your intput.");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Please input the student first name:  ");
                    String studentfname = sc.next();
                    System.out.println("Please input the student last name:  ");
                    String studentlname = sc.next();
                    for (int i = 0; i < listResult.size(); i++) {
                        if ((listResult.get(i).getStudent().getFirstName().equalsIgnoreCase(studentfname)) && (listResult.get(i).getStudent().getLastName().equalsIgnoreCase(studentlname))) {
                            stupos.add(i);
                            vars = true;
                        }
                    }
                    if ((!vars) && var) {
                        System.out.println("Error2 : Input student name is wrong! please check your intput.");
                    }
                    break;
                }
            }
        }
        return stupos;
    }

    private List<Integer> searchResultCoursePosition() {
        List<Integer> courpos = new ArrayList();
        Boolean var = true;
        if (listResult.isEmpty()) {
            System.out.println("This result list is empty.");
            var = false;
        } else {
            System.out.println("please <Enter-1> for the course No. or <Enter-2> for course name: ");
            int id = sc.nextInt();
            Boolean varc = false;
            switch (id) {
                case 1: {
                    System.out.println("Please input the course No. :  ");
                    double courseid = sc.nextDouble();
                    for (int i = 0; i < listResult.size(); i++) {
                        if (listResult.get(i).getCourse().getNo() == courseid) {
                            courpos.add(i);
                            varc = true;
                        }
                    }
                    if ((!varc) && var) {
                        System.out.println("Error3 : Input course NO. is wrong! please check your intput.");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Please input the course name:  ");
                    String coursename = sc.next();

                    for (int i = 0; i < listResult.size(); i++) {
                        if (listResult.get(i).getCourse().getCourseName().equalsIgnoreCase(coursename)) {
                            courpos.add(i);
                            varc = true;
                        }
                    }
                    if ((!varc) && var) {
                        System.out.println("Error4 : Input course name. is wrong! please check your intput.");
                    }
                    break;
                }
            }
        }
        return courpos;
    }
}
