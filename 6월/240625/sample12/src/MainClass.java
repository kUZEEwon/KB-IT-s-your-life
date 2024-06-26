public class MainClass {
    public static void main(String[] args) {
        /*
        * constructor : 생성자
        *               생성과 동시에 초기 값을 설정하기 위해서
        *               class 명과 같은 메소드
        *               return 값이 없음
        *               자동 호출 된다. => 객체 생성시
        *               별도의 호출이 불가능하다.
        *               Overload가 가능하다.
        *               생략이 가능하다.
        *
        * destructor : 소멸자
        *
        * Overload : 같은 이름의 함수(메소드)로 매개변수로 구분된다.
        * paint();
        * paint(int x, int y);
        *
        * 배열: 같은 자료형 변수의 묶음
        * 구조체: 다른 자료형 변수의 묶음
        * typedef struct {
        *   int num;
        *   float height;
        * }MyStruct;
        *
        * MyStruct mys = {1, 23.435}; -> 이거 가능함 왜냐면 구조체라서
        *
        * MyClass cls = new MyClass();
        *
        *
        * 구조체 vs 클래스 : 접근제어자의 차이(구조체 => public, 클래스 => private)
        * */

       // MyClass myc = {1, "hello"};
       // stack         heap

        MyClass myClass = new MyClass();


        int n = Integer.parseInt("219");
        int bin =  Integer.parseInt("1000", 2);

        //MyClass myOne = new MyClass(32, "jiwon");

        String str = "Hello";
        String str1 = "World";
        String str2 = str + str1;

        String str3 = new String("Hello");
        String str4 = new String("World");
        String str5 = str3.concat(str4);    // concat :  두 개의 문자열을 하나로 연결
        /*
        *   concat 메서드와 + 연산자의 차이점
        *
            concat 메서드:
            두 문자열을 연결하는 데 사용됩니다.
            null 값을 인수로 전달할 수 없습니다(NullPointerException이 발생할 수 있음).

            + 연산자:
            문자열을 더하는 데 사용됩니다.
            문자열 이외의 다른 타입도 연결할 수 있습니다.
            null 값을 포함하여 더할 수 있으며, null이 문자열로 변환됩니다.
        * */
    }
}


class MyClass{
    private int number;
    private String name;

    // 생성자  overload 가능해
    public MyClass(){   // 기본 생성자
        // 매개변수 2개인 생성자 호출
        this(1, "nobody"); // 생성자의 맨 첫줄에 위치해야 한다.
        System.out.println("MyClass MyClass()");
        this.number = 0;
        this.name = "";
    }

    public MyClass(int number) {
        this.number = number;
    }

    public MyClass(int number, String name) {
        //this();
        System.out.println("MyClass MyClass(int number, String name)");
        this.number = number;
        this.name = name;
        // this 는 구분자
    }

    public void method(){
        System.out.println("MyClass method()");
    }

    public void method(int i){
        System.out.println("MyClass method(int)");
    }
}