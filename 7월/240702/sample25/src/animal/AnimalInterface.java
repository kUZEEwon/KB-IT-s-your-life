package animal;

public interface AnimalInterface {

    // 일반 메서드는 사용 불가능
   /* public void move(){
        System.out.println("AnimalInterface.move");
    }*/

    public void move();

    public void eat();

    public void sleep();

    public default void live(){
        System.out.println("i am live");
    }
}
