package fruitshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    ArrayList<Fruit> fruits = new ArrayList<>();
    HashMap<String, List<ShoppingCart>> orders = new HashMap<>();
    ArrayList<Customer> customers = new ArrayList<>();
    Validate validate = new Validate();
    int fruitIdCounter = 1;

    public Customer checkIdExist() {
        String id = validate.inputString("Enter customer ID:");
        if (customers.isEmpty()) {
            String name = validate.inputString("Enter your name:");
            String phone = validate.inputString("Enter your phone number:");
            customers.add(new Customer(id, name, phone));
            return new Customer(id, name, phone);
        }
        for (Customer customer : customers) {
            if (!id.equalsIgnoreCase(customer.getId())) {
                String name = validate.inputString("Enter your name:");
                String phone = validate.inputString("Enter your phone number:");
                customers.add(new Customer(id, name, phone));
                return new Customer(id, name, phone);
            } else {
                return customer;
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
        if (orders.isEmpty()) {
            System.err.println("No orders have been placed.");
            return;
        }

        int i = 1;
        for (String customerName : orders.keySet()) {
            System.out.println("Customer: " + customerName);

            List<ShoppingCart> carts = orders.get(customerName);

            for (ShoppingCart cart : carts) {
                System.out.println("Order " + i);
                i++;
                System.out.printf("%-8s| %-9s| $%-6s| $%-6s%n", "Product", "Quantity", "Price", "Amount");
                for (Fruit fruit : cart.getItems()) {
                    System.out.printf("%-8s| %-9d| $%-6.2f| $%-6.2f%n",
                            fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getTotalPrice());
                }
            }

            double total = carts.stream().mapToDouble(ShoppingCart::getTotalPrice).sum();
            System.out.println("Total: $" + total);
        }
    }

    public void shopping() {
        List<Fruit> orderedItems = new ArrayList<>();
        Customer customer = checkIdExist();
        while (true) {
            System.out.println("List of Fruits:");
            System.out.printf("%-4s | %-12s | %-7s | %-5s%n", " Item", "Fruit Name", "Origin", "Price");

            for (Fruit fruit : fruits) {
                System.out.printf("%-4s | %-12s | %-7s | $%-5.2f%n", fruit.getFruitId(),
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }

            int selectedItem = validate.inputInt("Select a fruit (Enter Item): ", 1, fruits.size());
            Fruit selectedFruit = fruits.get(selectedItem - 1);

            System.out.println("You selected: " + selectedFruit.getFruitName());
            
            int quantity = validate.inputInt("Please input quantity: ", 1, Integer.MAX_VALUE);

            if (quantity > selectedFruit.getQuantity()) {
                System.err.println("Not enough quantity in stock. Please try a lower quantity.");
                continue;
            }

            boolean fruitExistsInOrder = false;
            for (Fruit orderedFruit : orderedItems) {
                if (orderedFruit.getFruitId().equals(selectedFruit.getFruitId())) {
                    orderedFruit.setQuantity(orderedFruit.getQuantity() + quantity);
                    selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
                    fruitExistsInOrder = true;
                    break;
                }
            }

            if (!fruitExistsInOrder) {
                selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);
                orderedItems.add(new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(),
                        selectedFruit.getPrice(), quantity, selectedFruit.getOrigin()));
            }

            if (!validate.checkInputYN("Do you want to continue")) {
                break;
            }
        }

        ShoppingCart cart = new ShoppingCart();
        cart.setItems(orderedItems);
        if (orders.containsKey(customer.getName())) {
            orders.get(customer.getName()).add(cart);
        } else {
            List<ShoppingCart> carts = new ArrayList<>();
            carts.add(cart);
            orders.put(customer.getName(), carts);
        }

        System.out.println("Total: $" + cart.getTotalPrice());
        System.out.println("Order processed successfully.");
    }

}
