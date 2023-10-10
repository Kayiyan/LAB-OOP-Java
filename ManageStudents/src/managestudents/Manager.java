package managestudents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;

public class Manager {

  ArrayList<Student> students = new ArrayList<>();
  Validate validation = new Validate();

  public ArrayList<Student> getListStudentById(String id) {
    ArrayList<Student> getListStudentById = new ArrayList<>();
    for (Student student : students) {
      if (id.equalsIgnoreCase(student.getId())) {
        getListStudentById.add(student);
      }
    }
    return getListStudentById;
  }

  public Student getStudentByListFound(ArrayList<Student> listStudentFindByID) {
    System.out.println("List student found: ");
    int count = 0;
    System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
        "semester", "Course Name");
    for (Student student : listStudentFindByID) {
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
    if(students.isEmpty()){
      System.out.println("Students list is empty!");
    }
    for (Student student : students) {
      String key = student.getId() + "#" + student.getStudentName() + "|" + student.getCourseName();
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
    for (Student student : students) {
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
      String course = validation.checkInputCourse("Enter course:");
      if (checkStudentExist(id, name, semester, course)) {
        students.add(new Student(id, name, semester, course));
      } else {
        System.out.println("This record is existed.");
      }
      if (students.size() > 10) {
        boolean yesorno = validation.checkYesNo("Do you want to continue:");
        if (!yesorno) {
          break;
        }
      }

    }
  }

  public void findAndSort() {
    String name = validation.inputString("Enter Name:");
    Collections.sort(students, Comparator.comparing(Student::getId).thenComparing(Student::getCourseName));
    if (students.isEmpty()) {
      System.out.println("No students");
    }
    for (Student student : students) {
      if (student.getStudentName().contains(name)) {
        student.print();
      }
    }

  }


  public void updateOrDelete() {
    String id = validation.inputString("Enter id: ");
    ArrayList<Student> listStudentFindByID = getListStudentById(id);
    if (listStudentFindByID.isEmpty()) {
      System.out.println("Not found student.");
    } else {
      Student student = getStudentByListFound(listStudentFindByID);
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
              for (Student change_name : students) {
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
  public void loadStudentData(){
    ArrayList<Student> studentData = StudentData.getStudentData();
    students.addAll(studentData);
  }
}