public class MainClass {


    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Carmy",4);
        Vehicle bike = new Bike("Yamaha", "MT-15", true);

        car.display();
        bike.display();
    }


}
