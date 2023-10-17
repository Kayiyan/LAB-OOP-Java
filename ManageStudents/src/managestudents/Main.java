package managestudents;

public class Main {

    public static void main(String[] args) {
        Validate validation = new Validate();
        Manager manager = new Manager();
        while (true) {
            System.out.println(" 1.Create");
            System.out.println(" 2.Find and Sort");
            System.out.println(" 3.Update/Delete");
            System.out.println(" 4.Report");
            System.out.println(" 5.Load students' data: ");
            System.out.println(" 6.Add course");
            System.out.println(" 7.Exit");
            int choice = validation.inputInt("Enter choice:", 1, 7);
            switch (choice) {
                case 1:
                    manager.createStudent();
                    break;
                case 2:
                    manager.findAndSort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.report();
                    break;
                case 5:
                    manager.loadStudentData();
                    break;
                case 6:
                    manager.addCourse();
                    break;
                case 7:
                    return;
            }

        }
    }
}
