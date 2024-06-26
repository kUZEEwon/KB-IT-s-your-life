package cls;

public class ParentClass {
    private int number;
    private String name;

    public ParentClass(){
        System.out.println("ParentClass Constructor");
        System.out.println("ParentClass this = " + this);
    }

    public ParentClass(int number, String name) {
        this();
        this.number = number;
        this.name = name;
    }

    public void method(){
        System.out.println("ParentClass method");
    }
}
