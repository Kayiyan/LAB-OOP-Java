package managestudents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;

public class Manager {

    ArrayList<StudentCourse> studentCourse = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    Validate validation = new Validate();

    public ArrayList<StudentCourse> getListStudentById(String id) {
        ArrayList<StudentCourse> getListStudentById = new ArrayList<>();
        for (StudentCourse student : studentCourse) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    public StudentCourse getStudentByListFound(ArrayList<StudentCourse> listStudentFindByID) {
        System.out.println("List student found: ");
        int count = 0;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (StudentCourse student : listStudentFindByID) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        int choice = validation.inputInt("Enter choice:", 0, listStudentFindByID.size() - 1);
        return listStudentFindByID.get(choice);
    }

    public void report() {
        HashMap<String, Integer> reports = new HashMap<>();
        if (studentCourse.isEmpty()) {
            System.out.println("Students list is empty!");
        }
        for (StudentCourse student : studentCourse) {
            String key = student.getId() + "#" + student.getStudentName() + "|" + student.getCourseName()+"|"+student.getStatus();
            if (reports.containsKey(key)) {
                int total = reports.get(key);
                reports.put(key, total + 1);
            } else {
                reports.put(key, 1);
            }

        }
        for (String key : reports.keySet()) {
            System.out.println(key.split("#")[1] + "|" + reports.get(key));

        }
    }

    public boolean checkStudentExist(String id, String name, String semester, String courseName) {
        for (StudentCourse student : studentCourse) {
            if (id.equals(student.getId())
                    && semester.equals(student.getSemester())
                    && name.equals(student.getStudentName())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    public Student checkIdExist(String id) {
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public void createStudent() {
        while (true) {
            String id = validation.inputString("Enter id:");
            Student student = checkIdExist(id);
            String name;
            if (student == null) {
                name = validation.inputString("Enter Name:");
            } else {
                name = student.getStudentName();
            }
            String semester = validation.inputString("Enter semester:");

            students.add(new Student(id, name, semester));

            if (students.size() > 10) {
                boolean yesorno = validation.checkYesNo("Do you want to continue:");
                if (!yesorno) {
                    break;
                }
            }

        }
    }

    public void addCourse() {
        while (true) {
            String id = validation.inputString("Enter student id:");
            Student student = checkIdExist(id);
            if (student == null) {
                System.out.println("Not found!");
            } else {

                String courseId = student.getId();
                String name = student.getStudentName();
                String semester = student.getSemester();
                String course = validation.checkInputCourse("Enter course name:");
                String status = validation.inputString("Enter status:");
                
                studentCourse.add(new StudentCourse(id, name, semester,course,status));
                    
            }
            if(!validation.checkYesNo("Do you want to continue: ")){
                break;
            }
        }
    }

public void findAndSort() {
        String name = validation.inputString("Enter Name:");
        if (students.isEmpty()) {
            System.out.println("No students");
        }
        Collections.sort(studentCourse, Comparator.comparing(StudentCourse::getId).thenComparing(StudentCourse::getCourseName));
        for (StudentCourse student : studentCourse) {
            if (student.getStudentName().contains(name)) {
                System.out.println(student.getStudentName() + student.getCourseName() + student.getSemester());
            }
        }

    }

    public void updateOrDelete() {
        String id = validation.inputString("Enter id: ");
        ArrayList<StudentCourse> listStudentFindByID = getListStudentById(id);
        if (listStudentFindByID.isEmpty()) {
            System.out.println("Not found student.");
        } else {
            StudentCourse student = getStudentByListFound(listStudentFindByID);
            if (validation.checkUD("Do you want update or delete")) {
                while (true) {
                    String name = validation.inputString("Enter name: ");
                    ;
                    String semester = validation.inputString("Enter semester: ");
                    String course = validation.checkInputCourse("Enter course: ");
                    if (!checkStudentExist(id, name, semester, course)) {
                        System.out.println("Duplicate");
                    } else {
                        if (!name.equalsIgnoreCase(student.getStudentName())) {
                            for (StudentCourse change_name : studentCourse) {
                                if (change_name.getId().equals(id)) {
                                    change_name.setStudentName(name);
                                }
                            }
                        }
                        student.setId(id);
                        student.setStudentName(name);
                        student.setSemester(semester);
                        student.setCourseName(course);
                        return;
                    }

                }

            } else {
                students.remove(student);
            }
        }
    }

    public void loadStudentData() {
        ArrayList<Student> studentData = StudentData.getStudentData();
        students.addAll(studentData);
    }
}
