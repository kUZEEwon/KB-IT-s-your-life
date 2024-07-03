import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // ArrayList 객체 생성

        // 자동형변환 (작은 객체 -> 큰 객체), Autoboxing
        list.add("자바"); // "자바" 문자열 추가 (자동형변환: Object <- String)
        list.add(new Human()); // Human 객체 추가 (자동형변환: Object <- Human)
        list.add(new ArrayList()); // ArrayList 객체 추가 (자동형변환: Object <- ArrayList)

        // 강제형변환 (큰 객체 -> 작은 객체), Unboxing
        String s = (String)list.get(0); // "자바" 문자열을 꺼내서 String 타입으로 강제형변환(큰 -> 작)

        list.add(100);
        int i = (Integer)list.get(3); // 정수 100을 꺼내서 Integer 타입으로 강제형변환 후 언박싱
    }
}

/*
* int는 일반자료형이구요 Integer는 Wrapper class입니다. 더 사용하기 좋게 만들어 놓은 것이죠. 예를들면 int는 다시 구현해야 하는 기능으로 문자열을 숫자로 바꾸는 기능등이 있죠 Integer.parseInt()
* */
