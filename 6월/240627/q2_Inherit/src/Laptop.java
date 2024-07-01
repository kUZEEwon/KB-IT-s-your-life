public class Laptop extends Move{

    public Laptop(int batteryCapacity, String color) {
        super(batteryCapacity, color);
    }

    public void charge(int additionalCapacity){
        this.batteryCapacity += additionalCapacity;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                '}' + super.toString();
    }
}
