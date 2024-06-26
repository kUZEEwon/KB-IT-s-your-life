import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainClass {

    public static void main(String[] args) {
        // Static 정적

        MyClass myCls = new MyClass();
        myCls.method("hi");
        myCls.method("hi");


        MyClass myCls2 = new MyClass();
        myCls2.method("hi");

        System.out.println("\nYouClass Static Method");
        YouClass.staticMethod();


        Student stu = Student.StudentInit("james",32);

        Calendar cal = Calendar.getInstance();          // Static
        GregorianCalendar gc = new GregorianCalendar();


    }
}

class MyClass {
    // 멤버변수와 static변수는 0으로 자동 초기화됨
    private int memNumber; // member variance
    public static int glNumber; // static(정적변수) 변수

    public void method (String s) {
        int number = 0; // local variance

        // local
        number++;
        System.out.println("number(local) = " + number);

        // member
        memNumber++;
        System.out.println("memNumber = " + memNumber);

        // static
        glNumber++;
        System.out.println("glNumber(static) = " + glNumber);


    }
}


class YouClass {
    private int Number;

    public void method () {
        MyClass.glNumber = 12;
    }

    public static void staticMethod () {
        System.out.println("staticMethod()");

        // this, super 사용 불가능
        int num = 0;  // static 변수 아니라 지역변수
    }
}


class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void init(){
        System.out.println("init");
    }

    public void start(){
        System.out.println("start");
    }

    public static Student StudentInit(String name, int age){
        Student st = new Student(name, age);
        st.init();
        st.start();
        return st;
    }
}