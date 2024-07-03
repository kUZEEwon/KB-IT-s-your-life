public class MainClass {

    public static void main(String[] args) {
        /*
        * Abstract Class : 추상 클래스
        *                   abstract method를 하나 이상 포함하고 있는 클래스
        *                   기본적으로 생성은 불가능하지만,
        *                   추상메소드를 정의하면 가능하다.
        * */

        // interface

        SubClass sc = new SubClass();
        sc.method();
        sc.AbstractMethod();

        AbstractClass scls = new AbstractClass() {
            @Override
            public void AbstractMethod() {
                System.out.println("AbstractMethod");
            }
        };

        scls.AbstractMethod();
        scls.method();

        AbstractClass sclss = new SubClass();
        sclss.method();
        sclss.AbstractMethod();
    }
}

// 추상 클래스 : 추상 메소드를 1개 이상 포함 (기본 생성은 안된다.)
abstract class AbstractClass {
    private String name;
    private int age;

    // 추상 메소드
    public abstract void AbstractMethod();

    // 일반 메소드
    public void method(){
        System.out.println("method");
    }
}

class SubClass extends AbstractClass {

    @Override
    public void AbstractMethod() {
        System.out.println("SubClass AbstractMethod");
    }
}