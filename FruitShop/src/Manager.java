import java.util.ArrayList;
import java.util.Hashtable;

public class Manager {
    ArrayList<Fruit> fruits = new ArrayList<>();
    Hashtable<String, ShoppingCart> orders = new Hashtable<>();
    Validate validate = new Validate();
    int fruitIdCounter = 1;

    public Fruit getFruitById(String fruitId) {
        for (Fruit fruit : fruits) {
            if (fruitId.equalsIgnoreCase(fruit.getFruitId())) {
                return fruit;
            }
        }
        return null;
    }

    public void createFruit() {
        String fruitId = String.valueOf(fruitIdCounter++);
        String fruitName = validate.inputString("Enter Fruit Name: ");
        double price = validate.inputDouble("Enter Price: ", 0.01, Double.MAX_VALUE);
        int quantity = validate.inputInt("Enter Quantity: ", 1, Integer.MAX_VALUE);
        String origin = validate.inputString("Enter Origin: ");

        Fruit newFruit = new Fruit(fruitId, fruitName, price, quantity, origin);
        fruits.add(newFruit);

        System.out.println("Fruit created successfully.");
    }


    public void viewOrders() {
        // Implement logic to view orders
        if (orders.isEmpty()) {
            System.err.println("No orders have been placed.");
            return;
        }

        // Iterate through orders and display order details
        for (String customerName : orders.keySet()) {
            System.out.println("Customer: " + customerName);
            ShoppingCart cart = orders.get(customerName);
            System.out.println("Product | Quantity | Price | Amount");

            for (Fruit fruit : cart.getItems()) {
                System.out.printf("%-8s| %-9d| $%-6.2f| $%-6.2f%n",
                        fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getTotalPrice());
            }

            System.out.println("Total: $" + cart.getTotalPrice());
        }
    }

    public void processOrder() {
        // Implement logic to process orders
        System.out.println("List of Fruits:");
        System.out.println("Fruit Id | Fruit Name | Origin | Price");

        for (Fruit fruit : fruits) {
            System.out.printf("%-9s| %-12s| %-7s| $%-5.2f%n",
                    fruit.getFruitId(), fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());


            ShoppingCart cart = new ShoppingCart();

            while (true) {
                int fruitId = validate.inputInt("Select a fruit (Enter Fruit Id): ", 1, fruitIdCounter - 1);
                String fruitIdStr = String.valueOf(fruitId); // Convert int to String
                Fruit selectedFruit = getFruitById(fruitIdStr); // Call the method with a String argument

                if (selectedFruit == null) {
                    System.err.println("Invalid Fruit ID. Please try again.");
                    continue; // Restart the loop to allow the user to enter a valid Fruit ID
                }

                int quantity = validate.inputInt("Enter Quantity: ", 1, Integer.MAX_VALUE);

                if (quantity > selectedFruit.getQuantity()) {
                    System.err.println("Not enough quantity in stock. Please try a lower quantity.");
                    continue; // Restart the loop to allow the user to enter a valid quantity
                }

                selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
                cart.addItem(selectedFruit, quantity);

                if (!validate.checkInputYN("Do you want to continue")) {
                    break;
                }
            }

            System.out.println("Order processed successfully.");
        }

    }
}


