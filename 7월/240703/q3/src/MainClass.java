import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello", "hi", "smile");

        // 1. 각 요소를 모두 대문자로 변경한 후, 글자 수가 4를 초과하는 데이터들의 list를 생성해 출력하세요 .
        List<String> Result = words.stream()
                .map(String::toUpperCase)
                .filter(x -> x.length() > 4)
                .collect(Collectors.toList());

        System.out.println(Result);

        // 2. 각 요소에 대해 “님"을 붙인 후, list를 생성해 출력하세요 .
        List<String> Result2= words.stream()
                .map(s -> s+"님")
                .collect(Collectors.toList());
        System.out.println(Result2);
    }
}
