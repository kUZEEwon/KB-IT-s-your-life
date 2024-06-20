package HW_4;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Item> items = new ArrayList<Item>();

    void addItem(Item item) {
        items.add(item);
    }

    double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    int getItemCount(){ return items.size(); }

    void displayOrder(){
        for (Item item : items) {
            System.out.println(item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + getTotal());
    }
}
