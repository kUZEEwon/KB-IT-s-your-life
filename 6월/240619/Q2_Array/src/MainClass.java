import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String orderProductTypes[] = {"샌드위치","바게트"};
        int orderProductPrices[] = {2000, 3500};
        int sandwichNum = 0;
        int baguetteNum = 0;
        int choice=-1;
        int Num = 0;


        while (true){
            System.out.println("주문할 상품을 선택하세요 (1: 샌드위치, 2: 바게트, 0: 주문 종료): ");

            choice = sc.nextInt();

            if(choice == 0) {
                System.out.println();
                System.out.println("최종 주문 내역:");
                System.out.println("샌드위치: " + sandwichNum + "개" );
                System.out.println("바게트: " + baguetteNum + "개" );
                System.out.println("최종 주문 가격: " + (sandwichNum*orderProductPrices[0] + baguetteNum * orderProductPrices[1]) + "원");
                break;
            }

            System.out.println("선택한 상품: " + orderProductTypes[choice-1]);




            System.out.println("주문할 수량을 입력하세요.: ");
            Num = sc.nextInt();
            System.out.println();

            if(choice == 1){
                sandwichNum = sandwichNum +Num;
            }else{
                baguetteNum = baguetteNum +Num;
            }


            System.out.println("현재 주문 상황: ");
            System.out.println("샌드위치: " + sandwichNum + "개" );
            System.out.println("바게트: " + baguetteNum + "개" );
            System.out.println("현재까지의 총 주문 금액: " + (sandwichNum*orderProductPrices[0] + baguetteNum * orderProductPrices[1]) + "원");

        }

    }
}
