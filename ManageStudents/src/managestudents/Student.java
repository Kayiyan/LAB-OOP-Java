package managestudents;
public class Student {
    private String id;
    private String studentName;
    private String semester;

    public Student(String id, String studentName, String semester) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;

    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentsName) {
        this.studentName = studentsName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

}
