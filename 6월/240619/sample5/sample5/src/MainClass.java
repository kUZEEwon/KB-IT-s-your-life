
public class MainClass {

    public static void main(String[] args) {

        /*
            while: loop문
                   반복문,

                   초기화
                   while( 조건 ){
                        처리
                        연산식
                   }

                   for(초기화 ; 조건식; 연산식){
                        처리
                   }
         */

        int w;

        w = 0;
        while (w < 10) {
            System.out.println(w);
            w++;
        }
        // System.out.println(w);

        /*
        w = 0;
        while (true) {
            System.out.println(w);
            w++;
        }*/

        // 이중 for
        int count = 1;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                //System.out.println(i);
                //System.out.println(count + "회");
                //count++;

                System.out.print(i + " x " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }

        // 이중 while
        int w1, w2;

        w1 = w2 = 0;

        while (w1 < 10) {
            System.out.println(w1);

            w2 = 0;
            while (w2 < 5){
                System.out.print(" " + w2);
                w2++;
            }
            System.out.println();
            w1++;
        }

        /*
            do while
         */

        int w3;
        w3 = 10;

        do{
            System.out.println("w3 = " + w3);
            w3++;
        }while (w3 < 5);


    }
}










