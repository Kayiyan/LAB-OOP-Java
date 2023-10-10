package managestudents;

import java.util.ArrayList;

public class StudentData {
  public static ArrayList<Student> getStudentData() {
    ArrayList<Student> students = new ArrayList<>();

    students.add(new Student("1", "Alice", "2", "Math"));
    students.add(new Student("2", "Bob", "3", "History"));
    students.add(new Student("3", "Charlie", "1", "Physics"));
    students.add(new Student("4", "David", "2", "Chemistry"));
    students.add(new Student("5", "Eve", "1", "Computer Science"));
    students.add(new Student("6", "Grace", "3", "English"));
    students.add(new Student("7", "Frank", "2", "Biology"));
    students.add(new Student("8", "Heidi", "1", "Art"));
    students.add(new Student("9", "Ivy", "4", "Geography"));
    students.add(new Student("10", "Jack", "3", "Music"));

    return students;
  }
}
