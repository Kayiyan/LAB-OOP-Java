package fruitshop2;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Fruit> items = new ArrayList<>();
    private double totalPrice = 0;


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
