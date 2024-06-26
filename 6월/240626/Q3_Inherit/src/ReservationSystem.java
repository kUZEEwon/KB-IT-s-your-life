import java.util.Scanner;

public class ReservationSystem {
    private Scanner sc = new Scanner(System.in);
    private Restaurant restaurant;
    
    ReservationSystem(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(10);
        ReservationSystem rs = new ReservationSystem(restaurant);
        rs.printMenu();

    }
    public void printMenu(){
        System.out.println("Choose an option:");
        System.out.println("1. Reserve a table");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Show current status");
        System.out.println("4. Exit");

        while(true){

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (restaurant.reserveTable()) {
                        System.out.println("Table reserved. Tables left: " + restaurant.getAvailableTables());
                    } else {
                        System.out.println("Reservation failed: No tables available.");
                    }
                    break;
                case 2:
                    restaurant.cancelReservation();
                    System.out.println("Reservation cancelled. Tables available: " + restaurant.getAvailableTables());
                    break;
                case 3:
                    System.out.println("Current tables available: " + restaurant.getAvailableTables());
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



