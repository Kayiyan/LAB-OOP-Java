import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Fruit> items = new ArrayList<>();
    private double totalPrice = 0;

//    public void addItem(Fruit fruit, int quantity) {
//        fruit.setQuantity(quantity);
//        items.add(fruit);
//        totalPrice += fruit.getTotalPrice();
//    }

    public List<Fruit> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setItems(List<Fruit> items) {
        this.items = items;
        totalPrice = items.stream().mapToDouble(Fruit::getTotalPrice).sum();
    }
}
