package HW_4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> menu = new ArrayList<Item>();
        Order order = new Order();

        Item burger = new Item();
        burger.setName("Burger");
        burger.setPrice(5.99);
        menu.add(burger);

        Item fries = new Item();
        fries.setName("Fries");
        fries.setPrice(2.99);
        menu.add(fries);

        Item soda = new Item();
        soda.setName("Soda");
        soda.setPrice(1.99);
        menu.add(soda);

        while(true){
            System.out.println("주문 가능한 메뉴입니다.");
            System.out.println("=======================");
            for(int i = 0; i < menu.size(); i++){
                System.out.println(menu.get(i).getName() + ": $" + menu.get(i).getPrice());
            }
            System.out.println();
            System.out.println("메뉴를 입력 (or 'x' to finish): ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("x")){ break; }

            boolean found = false;

            for(Item item : menu){
                if(item.getName().equalsIgnoreCase(input)){
                    order.addItem(item);
                    System.out.println("Added item: " + item.getName());
                    found = true;
                    break;
                }
            }

            if(!found){
                System.out.println("Item not found in the menu.");
            }
        }

        System.out.println("\nYour Order: ");
        order.displayOrder();
        System.out.println("Total items ordered: " + order.getItemCount());
    }
}
