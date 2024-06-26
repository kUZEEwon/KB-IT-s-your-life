package Number;

public class TwoClass extends OneClass {
    String name;
    // this(자기 참조), super(부모 참조)

    public TwoClass() {
        super(3);
        System.out.println("TwoClass TwoClass()");
    }

    public TwoClass(String name) {
        this.name = name;
    }
}
