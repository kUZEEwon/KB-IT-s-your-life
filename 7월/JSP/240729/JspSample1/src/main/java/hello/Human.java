package hello;

public class Human {
    private String name;
    private int age;



    public Human() {
    }

    public Human(String name,int age ) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
