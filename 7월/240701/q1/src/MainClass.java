import java.util.ArrayList;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        // q1
        ArrayList<String> list = new ArrayList<>();

        list.add("박소정");
        list.add("김경민");
        list.add("소지현");
        list.add("김개빈");
        System.out.println("초기 참가자 목록 : "+list);
        list.remove("김경민");
        System.out.println("탈락 후 참가자 목록 : "+list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(
                    (i+1)+"등 : "+list.get(i)
            );
        }

        // linkedlist
        System.out.println("linkedlist\n\n");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("국어");
        linkedList.add("수학");
        linkedList.add("영어");
        linkedList.add("컴퓨터");

        // 초기 시험 과목 출력
        System.out.println("처음 시험 본 과목 : "+linkedList );

        // 각 시험 회차 후 과목 제거 및 출력
        linkedList.removeFirst();
        System.out.println("1회차 시험을 한 날은 과목 : " + linkedList);

        linkedList.removeFirst();
        System.out.println("2회차 시험을 한 날은 과목 : " + linkedList);

        linkedList.removeLast();
        System.out.println("3회차 시험을 한 날은 과목 : " + linkedList);
    }
}
