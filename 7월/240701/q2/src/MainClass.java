import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
문제

- 고객관리 시스템에서 100번의 고객은
김데이, 200번의 고객은 김사전, 300번의
고객은 김구조, 400번의 고객은 김자료.

- 200번의 고객은 탈퇴, 300번의 고객은 개명
=> 김충성

- 고객의 전체 리스트를 프린트!
* */
public class MainClass {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        // 고객 정보 입력
        map.put(100,"김데이");
        map.put(200,"김사전");
        map.put(300, "김구조");
        map.put(400,"김자료");

        // 고객 정보 수정
        map.remove(200);
        map.remove(300,"김충성");


        System.out.println("고객 전체 리스트:");
       for (Map.Entry<Integer, String> entry : map.entrySet()) {
           System.out.println("고객 번호 : "+entry.getKey() + ", 이름 : " + entry.getValue());
       }


    }
}
