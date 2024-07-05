import java.util.*;

import java.util.function.Consumer;
import java.util.stream.Collectors;


public class MainClass {
    static  int sum1= 0;
    public static void main(String[] args) {

        /*
        * Lambda
        * (코드의) 간략화, 가독성
        *
        * ( 매개 변수 ) -> { 처리 }
        * () -> { 처리 }
        * ( str ) -> { 처리 }
        * ( str, n ) -> { 처리 }
        * (String s, int n) -> { 처리 }
        * */

        int result = Calculator.Calculate(3, 6, (a,b) -> a + b);
        System.out.println(result);

        result = Calculator.Calculate(3, 6, (a,b) -> a * b);
        System.out.println(result);

        // 일반적인 생성
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("consumer.accept");

        // 람다식으로
        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept("consumer1.accept lambda");

        // List
        System.out.println("\nList---------------------------------------");
        List<String> list = Arrays.asList("Giants", "Tigers", "Lions");
//        list.forEach(System.out::println);

       /* list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        // lambda를 이용해서 출력해보기
        list.forEach(s -> System.out.println(s));


        //////////////////////////3

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x * y;
            }
        };

        int result1 = comparator.compare(12, 2);
        System.out.println("result1 : "+result1);

        Comparator<Integer> comparator2 = (Integer x, Integer y) -> {return x+y;};
        int result2 = comparator2.compare(7, 8);
        System.out.println("result2 : "+result2);



        /////////////////////////4 List
        System.out.println("\n4. List---------------------------------------");
        List<String> fruitList = Arrays.asList("Apple", "Pear", "banana");
        fruitList.forEach(s -> System.out.println(s));

        ////////////////////////5
        List<Integer> numbers = Arrays.asList(11,22,43,45,72,623,96);
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);

        //AtomicInteger atomicInteger = new AtomicInteger();
        numbers.forEach(number -> sum1 += number);
        System.out.println(sum1);

        // stream(흐름) 사용하는 방법   -> list 간략화, 가독성 높이기
        // 지연연산
        // 병렬처리 ().().().

        List<String> words = Arrays.asList("Hello", "hi", "smile");
        List<String> Result = words.stream()
                .map(String::toUpperCase)
                .filter(x -> x.length() > 4)
                .collect(Collectors.toList());

        System.out.println("Result : "+Result);

        System.out.println(Arrays.asList(5,23,62,72,38,12,6).stream());
        Arrays.asList(5,23,62,72,38,12,6).stream()
                                        .forEach(System.out::println);

        Arrays.asList(5,23,62,72,38,12,6).stream()
                                        .map(k -> k * 2)
                                        .forEach(System.out::println);

        Arrays.asList(5,23,62,72,38,12,6).stream()
                                        .map( k -> k >10)
                                        .forEach(System.out::println);

        // 합계
        int sum2 = Arrays.asList(5,23,62,72,38,12,6).stream().reduce(0, (i, j) -> i+j);
        //(((5+23)+62)+72...)
        System.out.println("sum2 : " +sum2);

        // 10보다 큰 요소 리턴  --->
        int r = Arrays.asList(5,23,62,72,38,12,6).stream()
                                                 .filter( i -> i > 10)
                                                 .findFirst().orElse(null);
        System.out.println("r : "+r); // 조건식에 true인것을 찾으면 바로 반환함
    }
}

@FunctionalInterface
interface Operator {
    public int operate(int a, int b);

}

class Calculator {
    public static int Calculate(int a, int b, Operator op) {
        return op.operate(a, b);
    }
}
