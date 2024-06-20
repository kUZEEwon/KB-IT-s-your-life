import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        String[] MovieName = {"명탐정코난VS괴도키드","인사이드 아웃","설계자","매드맥스:분노의 도로","파묘"};
        int[] cost = {11000,7150,11000,1300,7000};

        for (int i = 0; i < MovieName.length; i++) {
            System.out.println((i+1)+". "+MovieName[i] + " - 가격: "+cost[i]  + "원");
        }
        int choice = -1;

        Scanner sc = new Scanner(System.in);

        System.out.println("정보를 확인하고 싶은 영화 번호를 선택하세요 (1-5):");
        choice = sc.nextInt();
        if (choice >0 && choice <= 5) {
            System.out.println("선택한 영화: "+MovieName[choice-1]);
            System.out.println("가격: " + cost[choice-1] + "원");
        }
    }
}
