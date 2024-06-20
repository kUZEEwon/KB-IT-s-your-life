import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {

        /*
            wrapper class
            일반 자료형(int double String)을 class로 만들어 놓은 것

            일반자료형       wrapper class
            boolean         Boolean
            byte            Byte
            short           Short
            int             Integer     !
            long            Long
            float           Float
            double          Double      !
            char            Character
            char[]          String      !

            MyClass cls = new MyClass();
         */

        char carr[] = { 'H', 'e', 'l', 'l', 'o' };
        System.out.println(carr);

        int i = 123;
        Integer iobj = 123;
        System.out.println(iobj);

        Integer iobj2 = new Integer(234);
        System.out.println(iobj2);

        Double dobj = 123.456;
        System.out.println(dobj);

        // 숫자 -> 문자열
        String iStr = 123 + "";
        System.out.println(iStr);

        String dStr = 123.456 + "";
        System.out.println(dStr);

        // 문자열 -> 숫자
        int iNum = Integer.parseInt(iStr);
        System.out.println(iNum);

        double dNum = Double.parseDouble(dStr);
        System.out.println(dNum);

        // 10진수 -> 2진수
        String num2 = Integer.toBinaryString(8);
        System.out.println(num2);

        // 2진수 -> 10진수
        int num10 = Integer.parseInt("1000", 2);
        System.out.println(num10);


        // String : 문자열의 저장, 편집, 정보 취득

        // 문자열 합하기
        String str = "Hello";
        String str1 = "World";
        String str2 = str + str1;
        System.out.println(str2);

        String str3 = "Hi";
        String str4 = "Nice To meet you";
        String str5 = str3.concat(str4);
        System.out.println(str5);

        // 문자열 비교
        String str6 = "Hello";
        String str7 = "He";

        str7 = str7 + "llo";

        if(str6 == str7){
            System.out.println("같은 문자열입니다");
        }else{
            System.out.println("다른 문자열입니다");
        }

        if(str6.equals(str7)){
            System.out.println("같은 문자열입니다");
        }else{
            System.out.println("다른 문자열입니다");
        }

        // 문자의 위치
        String str8 = "abcabcabc";
        int n = str8.indexOf("a");
        System.out.println(n);

        n = str8.lastIndexOf("a");
        System.out.println(n);

        // 문자열의 길이
        int len = str8.length();
        System.out.println(len);

        // 문자열을 수정
        String str9 = "A*B*C*D*E*F*G*H";
        String str10 = str9.replace("*", "-");
        System.out.println(str10);

        String str11 = str9.replace("*", "");
        System.out.println(str11);

        // 앞뒤의 공백을 없애줄 경우
        String str12 = "       I like Iphone    ";
        String str13 = str12.trim();
        System.out.println(str13);

        // 문자열 자르기
        String str14 = "홍길동-24-2001/10/12-서울시";     // - token

        String str15[] = str14.split("-");
        System.out.println(Arrays.toString(str15));

        // 범위로 자르기
        String str16 = str14.substring(7, 17);
        System.out.println(str16);

        // ..번째의 숫자를 넣으면 한개의 문자를 산출
        String str17 = "가나다라마";   // str17[2]
        char c = str17.charAt(2);
        System.out.println(c);

        // 문자열을 탐색          탐색, 정렬, 셔플, 트리
        String str18 = "서울시 강남구 논현동";
        boolean b = str18.contains("성북");
        System.out.println(b);


    }
}








