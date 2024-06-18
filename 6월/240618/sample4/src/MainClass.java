import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        /*
        * loop문, 순환문
        *
        * for( 초기화 & 선언 ; 조건 ; 연산식 ){
        *   // 처리
        * }
        *
        * array.forEach((item, index) => {
        *
        * })
        * */

        int n = 0;
        for(n=0; n<10; n++) {
            System.out.println(n);
        }

        for(int i=0; i<10; i++) {
            System.out.println(i);
        }


        // forEach
        int array[] = {11, 22, 33, 44, 55};
        int sum = 0;
        for(int i=0; i<array.length; i++) {
            sum += array[i];
        }
        System.out.println("합계: " + sum);

        sum = 0;
        for(int num : array){
            sum += num;
        }
        System.out.println("합계: " + sum);


        // Scanner : 콘솔에 입력
        Scanner sc = new Scanner(System.in);

        // int
        int number;
        System.out.println("number: ");
        number = sc.nextInt();

        System.out.println("number: " + number);

        // String
        String str;
        System.out.println("String: ");
        str = sc.next();

        System.out.println("String: " + str);

        // double
        double d  = 0.0;
        System.out.println("Double: ");
        d = sc.nextDouble();

        System.out.println("Double: " + d);
    }
}
