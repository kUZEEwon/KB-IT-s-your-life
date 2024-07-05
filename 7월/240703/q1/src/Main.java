import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("어떤 객체를 생성하시겠습니까? (Apple, Banana, Ice, 종료하려면 'exit' 입력): ");
            String type = sc.next();

            // 종료 조건을 먼저 체크
            if (type.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                // ObjectFactory를 통해 객체를 생성
                ObjectFactory.createObject(type);
                System.out.println(type+"가(이) 입력되었습니다.\n");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
