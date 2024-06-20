public class MainClass {
    public static void main(String[] args) {
        /*
        *  OOP
        *  처리 후에 순차적을 작성 -> 절차 지향
        *
        *  프로그램 기획
        *  처리(프로세스) ->  입력, 정렬, 결과 출력
        *  상응하는 변수 -> 멤버 변수(Property)
        *  코드를 분산
        *
        * 형식:
        *
        * class 클래스명 {
        *   멤버 변수
        *
        *   멤버 함수(메소드)
        * }
        *
        * 클래스명 클래스변수(instance) = new 클래스 명
        * */

        MyClass cls = new MyClass();
        System.out.println(cls); // 객체 : 4 bytes
        cls.number = 1;
        cls.name = "홍길동";
        cls.height = 180;
        cls.method();
        cls.function();
    }
}


class MyClass {
    int number;
    String name;
    double height;

    void method(){
        // method
        System.out.println("MyClass method()");
    }

    void function(){
        System.out.println("MyClass function()");
    }
}