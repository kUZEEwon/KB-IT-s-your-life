import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        int total = 0;

        // 배열의 모든 값을 0으로 설정
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        while (true) {
            System.out.println("현재 좌석 상태: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print((i+1)+":"+arr[i]+" ");
            }
            System.out.println();

            // 좌석 번호 입력 받기
            System.out.print("예매할 좌석 번호를 입력하세요 (종료하려면 0 입력): ");
            int seatNum = sc.nextInt();

            if(seatNum == 0){

                System.out.println("예매된 좌석 수: " + total);
                System.out.println("총 예매 금액: " + 10000*total);
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 좌석 예매 처리
            if(seatNum > 0 && seatNum < arr.length+1) {
                if (arr[seatNum-1] == 0) {
                    arr[seatNum - 1] = 1;
                    total++;
                    System.out.println(seatNum + "번 좌석이 예매 되었습니다.");
                }else{
                    System.out.println("이미 예매된 좌석입니다.");
                }
            }else{
                System.out.println("잘못된 좌석 번호 입니다. 다시 입력하세요.");
            }
        }
    }
}
