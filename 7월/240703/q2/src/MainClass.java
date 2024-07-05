import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> overThree = numbers.stream()
                .filter(k -> k > 3)
                .collect(Collectors.toList());

        System.out.println(overThree);

        List<Integer> multiTen = numbers.stream()
                .map(k -> k * 10)
                .collect(Collectors.toList());
        System.out.println(multiTen);
    }
}
