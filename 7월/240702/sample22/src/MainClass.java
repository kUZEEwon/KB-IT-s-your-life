import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class MainClass {
    public static void main(String[] args) {
        /*
        * ArrayList : 검색
        *
        * LinkedList : link(연결) 목록
        *               실시간 처리에 적합함
        * */

        ArrayList<Objects> list = new ArrayList<>();


        LinkedList<String> linkedList = new LinkedList<String>();
        // 추가
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        System.out.println("_____________________________________________");
        for (String s : linkedList) {
            System.out.println(s);
        }

        // 원하는 위치에 추가
        linkedList.add(1,"E");

        System.out.println("1번에 E 추가_____________________________________________");
        for (String s : linkedList) {
            System.out.println(s);
        }

        // addFirst, addLast: linkedlist에만 존재함
        linkedList.addFirst("First");
        linkedList.addLast("Last");

        System.out.println("addFirst, addLast 사용____________________________________________");
        for (String s : linkedList) {
            System.out.println(s);
        }

        // 삭제
        linkedList.remove("A");

        System.out.println("\nA 삭제 완료____________________________________________");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("["+i+"] = "+linkedList.get(i));
        }

        // 검색
        System.out.println("\nLast 검색____________________________________________");
        String find ="Last";
        for (int i = 0; i < linkedList.size(); i++) {
            if(find.equals(linkedList.get(i))){
                System.out.println("["+i+"] = "+linkedList.get(i));
            }
        }


        // 수정
        linkedList.set(0, "updateFirst");
        System.out.println("\n0번지 수정____________________________________________");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("["+i+"] = "+linkedList.get(i));
        }

        // 반복자: iterator(주소, 포인터)
        Iterator<String> iterator = linkedList.iterator(); // 초기값
        // 0x1000 -> 0x2000 -> 0x3000

        System.out.println("\niterator____________________________________________");
        while (iterator.hasNext()) { // 그 다음의 주소가 있는지 확인
            String value = iterator.next();
            System.out.println(value);
        }

        // Arraylist와 Linkedlist는 호환 가능!
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("jiwon");
        list1.add("snow white");
        list1.add("snow black");

        LinkedList<String> linkedList2 = new LinkedList<>(list1);
        System.out.println("\nlinkedList2____________________________________________");
        for(String s : linkedList2){
            System.out.println(s);
        }

    }
}
