import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        /*
            loop문, 순환문

            for( 초기화 & 선언 ; 조건 ; 연산식 ){
                // 처리
            }
         */

        /*
        int n = 0;
        for(n = 0; n < 10; n++) {   // 0 ~ 9
            System.out.println(n);
        }
         */

        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
        /*
        for (i = 1; i < 11; i++) {
            System.out.println(i);
        }

        array.forEach((item, index)=>{
        })
        */

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }

        // foreach
        int array[] = { 11, 22, 33, 44, 55 };
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("합계:" + sum);

        sum = 0;
        for(int num : array){
            sum += num;
        }
        System.out.println("합계:" + sum);

        // Scanner : 콘솔에 입력
        Scanner sc = new Scanner(System.in);

        // int
//        int number;
//        System.out.print("number = ");
//        number = sc.nextInt();
//        System.out.println("number = " + number);

        // String
//        String name = "";
//        System.out.print("name = ");
//        name = sc.next();
//        System.out.print("이름 = " + name);

        // double
        double d = 0.0;
        System.out.print("height = ");
        d = sc.nextDouble();
        System.out.println("신장 = " + d);


    }
}



