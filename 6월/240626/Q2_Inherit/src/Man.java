public class Man extends Human{
    int power;

    public Man(String name, int age, int power) {
        super(name, age);
        this.power = power;
    }

    public void run(){
        System.out.println(name +"(이)가 달립니다.");
    }
}
