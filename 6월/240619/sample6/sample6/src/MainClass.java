
public class MainClass {

    public static void main(String[] args) {
        /*
            loop 문과 함께 사용
            break == return

            탈출을 의미

            switch(변수){
                case 1:
                    처리
                    break;
                case 2:
                    처리
                    break;
            }

            int arr[] = { 1, 3, 5, 6, 7, 9 };
            for(int i = 0;i < arr.length; i++){
                if(arr[i] == 6){
                     break;
                }
            }
         */

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if(i == 23){
                // 처리
                break;
            }
        }

        int number[] = { 1, 5, 3, -4, 2, 7 };

        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
            if(number[i] < 0){
                break;
            }
        }

        // 이중 for문
        /*for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for(int j = 0; j < 10; j++){
                System.out.println(" " + j);

                if(i == 3 && j == 4){
                    break;
                }
            }
        }*/

        // 1. for문 수에 맞게 break를 설정
        /*
        boolean b = false;
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for(int j = 0; j < 10; j++){
                System.out.println(" " + j);

                if(i == 3 && j == 4){
                    b = true;
                }
                if(b){
                    break;
                }
            }
            if(b){
                break;
            }
        }*/

        // 2. break를 설정
        for_out:for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for(int j = 0; j < 10; j++){
                System.out.println(" " + j);

                if(i == 2 && j == 3){
                    break for_out;
                }
            }
        }

        /*
            continue: skip(생략)

            loop 문과 같이 사용

            while(true){
                처리1

                if(조건){
                    continue;
                }

                처리2     <--- 처리생략
            }
         */

        for(int i = 0; i < 10; i++){
            System.out.println(i);

            System.out.println("처리 1");

            if(i == 4){
                continue;
            }

            System.out.println("처리 2");
        }

        int ages[] = { 12, 23, -2, 19, -9, -99, 25, 33 };

        for (int i = 0; i < ages.length; i++) {
            if(ages[i] <= 0){
                continue;
            }
            System.out.println(ages[i]);
        }
    }
}
