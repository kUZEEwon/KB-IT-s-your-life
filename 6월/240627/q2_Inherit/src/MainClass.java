public class MainClass {
    public static void main(String[] args) {
        Move move = new Smartphone(80, "RED",20);
        Move move2 = new Tablet(80, "GREEN",false);
        Move move3 = new Laptop(100,"SILVER");

        System.out.println(move);
        System.out.println(move2);
        System.out.println(move3);


    }
}
