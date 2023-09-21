package Woker;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Validate validate = new Validate();
        while(true){
            System.out.println("1.Add worker.");
            System.out.println("2.Increase salary for worker.");
            System.out.println("3.Decrease salary for worker.");
            System.out.println("4.Show adjusted salary worker infomation.");
            System.out.println("5.Exit.");
            System.out.println("6.Print Status");
            int choice = validate.age_Range("Enter choice: ",1,6);
            switch (choice){
                case 1:
                    manager.addWorker();
                    break;
                case 2:
                    manager.changeSalary("UP");
                    break;
                case 3:
                    manager.changeSalary("DOWN");
                    break;
                case 4:
                    manager.printHistory();
                    break;
                case 5:
                    return;
                case 6:
                    manager.printStatus();
            }


        }
    }
    
}
