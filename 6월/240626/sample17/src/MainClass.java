public class MainClass {
    public static void main(String[] args) {
        /*
        * final : 제약
        *         변수, 메소드, 클래스
        * */
        // 변수
        final int number = 12; // 상수(값 변경 불가능)

        final int MAX  = 1000;

        int num = MAX;


    }
}

final class SuperClass { // final : 상속 금지
    public final void method(){
        // OverRide 금지
        System.out.println("SuperClass method");
    }
}
