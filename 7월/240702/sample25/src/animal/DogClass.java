package animal;

public class DogClass implements AnimalInterface
{
    @Override
    public void move() {
        System.out.println("Dog move");
    }

    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleep");
    }

    @Override
    public void live() {
        AnimalInterface.super.live();
        System.out.println("Dog live");
    }
}
