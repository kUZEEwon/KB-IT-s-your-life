import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        /*
        * HashMap : 사전
        *           KEY : Value -> pair(한 쌍)로 관리
        *           "apple" : "사과"
        *           트리 구조
        *           key 값은 중복을 허용하지 않음
        *
        * TreeMap : HashMap + sorting(정렬)
        *
        * */

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        // 추가
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");

        // Value 불러오기
        System.out.println(hashMap.get(3));



        // 삭제(key 값을 이용해서)
        hashMap.remove(2);
        System.out.println("2번 값 삭제 : "+hashMap.get(2));


        // 검색
        // key값의 존재 유무를 검사
        boolean b = hashMap.containsKey(3);
        System.out.println(b);

        if(hashMap.containsKey(3)) {
            System.out.println(hashMap.get(3));
        }



        // 수정
        // put
        hashMap.put(2, "둘");
        System.out.println(hashMap.get(2));

        // replace
        hashMap.replace(3,"삼");
        System.out.println(hashMap.get(3));

        // 모두 출력 -> Iterator
        System.out.println("\n전체 출력_____________________________________________________________");
        Iterator<Integer> it = hashMap.keySet().iterator();
        while(it.hasNext()) {
            Integer key = (Integer)it.next();

            String value = hashMap.get(key);
            System.out.println(key+" : "+value);
        }

        // HashMap
        // HashMap<String,Object > hashMap1 = new HashMap<>();

        // sorting
        // TreeMap <--> HashMap

        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put("grape", "포도");
        hashMap1.put("strawberry","딸기");
        hashMap1.put("apple","사과");
        hashMap1.put("tomato", "토마토");
        System.out.println("\nHashMap 출력");


        Iterator<String> it1 = hashMap1.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            System.out.println(key + ":" + hashMap1.get(key));
        }

        TreeMap<String, String> treeMap = new TreeMap<>(hashMap1);

        // 오름차순 정렬
        System.out.println("\n오름 차순 정렬");
        Iterator<String> up_it = treeMap.keySet().iterator();
        while(up_it.hasNext()) {
            String key = up_it.next();
            System.out.println(key + " : " + treeMap.get(key));
        }

        // 내림차순 정렬
        System.out.println("\n내림 차순 정렬");
        Iterator<String> it2 = treeMap.descendingKeySet().iterator();
        while(it2.hasNext()) {
            String key = it2.next();
            System.out.println(key + " : " + treeMap.get(key));
        }


        System.out.println("\nHashMap 출력");
        it1 = hashMap1.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            System.out.println(key + ":" + hashMap1.get(key));
        }

    }
}
