public class MainClass {
    public static void main(String[] args) {
        One one = new One(32);
        Two two = new Two("jiwon");

        one.oneMethod();
        two.twoMethod();
        one.oneFunc();

        Three three = new Three();
        three.threeMethod();

       // SingletonClass sc = SingletonClass.getInstance();
       // System.out.println(sc);
    }
}
