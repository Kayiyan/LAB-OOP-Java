package managestudents;

public class StudentCourse extends Student {

    private String courseName;
    private String status;

    public StudentCourse(String id, String studentName, String semester,String courseName, String status) {
        super(id, studentName, semester);
        this.courseName = courseName;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
                

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
