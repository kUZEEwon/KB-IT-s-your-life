public class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String brand, String model, boolean hasCarrier) {
        super(brand, model);
        this.hasCarrier = hasCarrier;
    }

    public boolean getHasCarrier() {
        return hasCarrier;
    }

    public void display(){
        super.display();
        if (hasCarrier) {
            System.out.println("Has Carrier : " + hasCarrier);
        }
    }
}
