import java.util.*;
import java.util.stream.*;

public class StreamExample
{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("jiwon");
        list.add("james");
        list.add("alice");
        list.add("alice");
        list.add("bob");

        // 중복요소 제거
        list.stream()
                .distinct()
                .forEach(n -> System.out.println(n));
        System.out.println();

        // j로 시작하는 요소만 필터링
        list.stream()
                .filter(n -> n.startsWith("j"))
                .forEach(n -> System.out.println(n));
        System.out.println();


        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("jiwon","여",90));
        studentList.add(new Student("jiyoung","남",88));
        studentList.add(new Student("bob","남",93));

        // Student를 score 스트림으로 변환
        studentList.stream()
                .mapToInt(s -> s.getScore())
                .forEach(score -> System.out.println(score));
        System.out.println();

        // 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted()
                .forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
        System.out.println();


        // 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getName() + " " + s.getScore()));
        System.out.println();

        Map<String, List<Student>> map = studentList.stream().collect(Collectors.groupingBy(s-> s.getGender()));
        List<Student> maleList = map.get("남");
        maleList.stream()
                .forEach(s -> System.out.println(s.getName() + " " + s.getGender()));
        System.out.println();

        List<Student> femaleList = map.get("여");

        femaleList.stream()
                .forEach(s -> System.out.println(s.getName() + " " + s.getGender()));
    }
}
