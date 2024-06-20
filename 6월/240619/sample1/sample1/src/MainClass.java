
public class MainClass {

    public static void main(String[] args) {

        // 출력
        // System.out.println("Hello World");

        // 주석문

        /*
            범위 주석문

            html <!-- -->
            jsp  <%-- --%>
            python ''' ''' #
         */

        /*
        System.out.print("Hello World");

        System.out.println();

        System.out.println("안녕하세요");
        System.out.println("한");
        System.out.println(1);
        System.out.println('A');

        System.out.printf("%d\n", 1024);
        System.out.printf("%s\n", "하이");
        System.out.printf("%c\n", 'A');
        System.out.printf("%f\n", 1.234);
        */

        // escape sequence \n, \\, \", \'


        /*

        상수 :    2진수 -> 0, 1
                 8진수 -> 0 ~ 7   8 -> 10 -> 010
                 10진수 -> 0 ~ 9
                 16진수 -> 0 ~ 9 A B C D E F -> 0xAF

                 10진수 -> 255 -> ff

                 backgroundColor: #ffffff -> rgb(255, 255, 255)

        변수 : 변경할 수 있는 별명을 가진 데이터 공간 == variable
               숫자, 문자, 문자열, 논리(true,false)형

               local(지역)변수,
               global(전역)변수 == static 변수
               member(class)변수
               매개(parameter)변수
        */

        // 수치
        byte by;    // 1 byte == 8 bit   -128 ~ 127
        by = 127;

        short sh;   // 2 byte

        int i;      // 4 byte

        long l;     // 8 byte
        l = 123456789L;

        float f;    // 4 byte   radian = 3.141592 -> PI
        f = 123.4567f;

        double d;   // 8 byte

        // 문자
        char c;     // 2 byte (유니코드:utf-8) -> c언어(1 byte) ASCII 영문자 + 특수문자
                    // multi byte 코드

        String str; // !=자료형  참조    <- char[]
        // wrapper class
        // (Integer, Character, ...)
        str = "안녕하세요";      // 5

        // 논리
        boolean b;      // true(1)/false(0)
        b = true;


        // cast(자료형) 변환
        byte by1 = 127;
        short sh1 = by1;    // (auto)형변환

        System.out.println(sh1);

        long l1 = 123;
        int i1 = (int)l1;  // (cast)형변환

        int num1, num2;
        num1 = 3;
        num2 = 2;

        double d1 = (double) num1 / num2;
        System.out.println(d1);
    }
}
