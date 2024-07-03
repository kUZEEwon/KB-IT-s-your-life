import dto.HumanDto;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        /*
        * Collection : 수집
        *
        * Array : 같은 자료형의 묶음. 정해진 요소만 사용해야 한다.
        * List : 데이터 관리를 유동적으로 할 수 있는 배열이다.
        *
        * ArrayList(== vector)
        *       배열처럼 관리, 사용할 수 있는 목록
        *       선형 구조 0-0-0-0-0
        *       검색속도가 빠르다.
        *       index 번호로 관리, 접근하다
        *
        *       검색속도가 빠르다.
        *
        * LinkedList
        *       실시간으로 추가, 삭제가 빠르다.
        * */

        ArrayList<Integer> list = new ArrayList<Integer>();

        // 추가
        list.add(111);
        list.add(222);
        list.add(333);
        list.add(444);

        int size = list.size(); // list의 길이
        System.out.println(size);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // get(index) : index안의 값을 불러오기
        }

        // foreach문
        for (Integer i : list) {
            System.out.println(i);
        }

        // 원하는 위치에 추가
        list.add(2,300);
        System.out.println("추가 완료");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("["+i+"]"+"="+list.get(i));
        }


        // 삭제
        list.remove(1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("["+i+"]"+"="+list.get(i));
        }


        // 검색
        int index = list.indexOf(333);
        System.out.println("찾으시는 데이터는 " + index + "번지");


        // 수정
        Integer updateData = 200;
        list.set(1, updateData);
        System.out.println("수정 완료");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("["+i+"]"+"="+list.get(i));
        }

        System.out.println("\n\nHumanList");
        ArrayList<HumanDto> humanList = new ArrayList<>();

        // 추가
        HumanDto humanDto= new HumanDto("홍길동",32, 194);
        humanList.add(humanDto);

        humanList.add(new HumanDto("구지원",25,159));

        humanList.add(new HumanDto("구지영",22,179));

        humanList.add(new HumanDto("홍길동",55,177));

        System.out.println(humanList.size());

        for (int i = 0; i < humanList.size(); i++) {
            HumanDto h = humanList.get(i);
            System.out.println("["+i+"]"+"="+h.toString());
        }

        // 원하는 곳에 추가
        HumanDto human = new HumanDto("정수동", 28, 195);
        humanList.add(2,human);
        System.out.println("\n추가 완료");

        for (int i = 0; i < humanList.size(); i++) {
            HumanDto h = humanList.get(i);
            System.out.println("["+i+"]"+"="+h.toString());
        }

        // 삭제(삭제할 내용이 한가지)
        System.out.println("\n\n삭제");

        String findName = "구지영";
        int findIndex = -1;
        for(int i = 0; i < humanList.size(); i++){
            HumanDto h = humanList.get(i);
            if(findName.equals(h.getName())){
                findIndex = i;
                break;
            }
        }
        humanList.remove(findIndex);

        // 결과 출력
        for (int i = 0; i < humanList.size(); i++) {
            HumanDto h = humanList.get(i);
            System.out.println("["+i+"]"+"="+h.toString());
        }

        // 삭제(여러개의 데이터)
        System.out.println("\n\n삭제(여러개의 데이터)");
        String findName2= "홍길동";
        for(int i = 0; i < humanList.size(); i++) {
            HumanDto h = humanList.get(i);
            if(findName2.equals(h.getName())){
                humanList.remove(h);
            }
        }

        // 결과 출력
        for (int i = 0; i < humanList.size(); i++) {
            HumanDto h = humanList.get(i);
            System.out.println("["+i+"]"+"="+h.toString());
        }

        // 검색
        humanList.add(new HumanDto("구지영",22,179));
        humanList.add(new HumanDto("홍길동",55,177));
        humanList.add(new HumanDto("홍길동",32, 194));

        System.out.println("\n\n'홍길동' 검색");
        String findName3 = "홍길동";

        ArrayList<HumanDto> findList = new ArrayList<>();

        for(int i = 0; i < humanList.size(); i++) {
            HumanDto h = humanList.get(i);
            if(findName3.equals(h.getName())){
                findList.add(h);
            }
        }

        // 결과 출력
        for (int i = 0; i < findList.size(); i++) {
            HumanDto h = findList.get(i);
            System.out.println("["+i+"]"+"="+h.toString());
        }

        // 수정
        System.out.println("\n\n1번 객체 수정");
        HumanDto updateHuman = new HumanDto("장기하",20, 160);
        humanList.add(1, updateHuman);

        for(int i = 0; i < humanList.size(); i++) {
            HumanDto h = humanList.get(i);
            System.out.println("["+i+"]"+"="+h.toString());
        }

        // 다른 자료형을 수집하는 것도 가능하다.
        ArrayList<String> sList = new ArrayList<>();

        // String, Integer, HumanDto
        System.out.println("\n\nString, Integer, HumanDto");
        ArrayList<Object> sList2 = new ArrayList<>();
        sList2.add("Hello");
        sList2.add(1025);
        sList2.add(human);
        sList2.add(findList);

        // 결과 출력
        for(int i = 0; i < sList2.size(); i++) {
            Object h = sList2.get(i);
            System.out.println("["+i+"]"+"="+h.toString());
        }
    }
}
