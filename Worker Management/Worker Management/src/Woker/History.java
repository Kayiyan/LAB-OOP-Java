package Woker;

public class History extends Worker {
    private String Status;
    private String Date;

    public History( String id, String name, int age, double salary, String workLocation,String workingDay,String Status, String Date) {
        super(id, name, age, salary, workLocation,workingDay);
        this.Status = Status;
        this.Date = Date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    
}
