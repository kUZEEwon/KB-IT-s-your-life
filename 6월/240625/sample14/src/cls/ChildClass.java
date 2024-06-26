package cls;

public class ChildClass extends ParentClass {
    public ChildClass() {
        super(21, "jiwon");
        System.out.println("ChildClass constructor");
        System.out.println("ChildClass super = " + super.toString());
        System.out.println("ChildClass thid = " + this);
    }

    // 고쳐서 기입
    public void method(){
        System.out.println("ChildClass method");
    }

    public void func(){
        System.out.println("ChildClass func");
    }
}
