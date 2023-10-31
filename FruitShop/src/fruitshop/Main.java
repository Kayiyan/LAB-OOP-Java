package fruitshop;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Validate validate = new Validate();

        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View Orders List");
            System.out.println("3. Process Order");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int choice = validate.inputInt("Enter your choice: ", 1, 4);

            switch (choice) {
                case 1:
                    manager.createFruit();
                    break;
                case 2:
                    manager.viewOrders();
                    break;
                case 3:
                    manager.shopping();
                    break;
                case 4:
                    return;
            }
        }
    }

}
