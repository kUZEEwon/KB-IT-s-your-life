import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        // Array(배열)
        /*
        * 같은 자료형의 묶음
        * int num1, num2 ... num10
        *
        * int arrNum[] = null;
        * int **pNum = null;;
        *
        * int arrNum[] = { 1, 2, 3 };
        *
        * int arr2[][] = {
        *
        * }
        *
        * int **arr
        *
        * int array[] = new int[10];
        *             동적 할당
        *
        * 메모리
        * stack     heap    static      sys
        * */

        int array[] = new int[5];   // index : 0 ~ 4
        // let array = new int(5); <- js 문법
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        int array1[] = { 0, 1, 2, 3, 4 };

        // 2차원 배열
        int array2[][] = { // 3, 4
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        System.out.println(array2.length);  // 3
        System.out.println(array2[0].length);


        int array21[][] = new int[3][];

        int arr1[] = {1, 2, 3};

        array21[0] = arr1;

        int arr2[] = {4, 5, 6, 7, 8 };
        array21[1] = arr2;

        System.out.println(array21); // heap영역의 주소(os 자동 할당)

        // aaa -> 100, bbb -> 100
        // aaa <- bbb, bbb <- aaa
        int numAaa[] = { 1, 2, 3, 4, 5 };
        int numBbb[] = { 11, 22, 33, 44, 55 };

        /*  방법 1
            for (int i = 0; i < numAaa.length; i++) {

            int temp = numAaa[i];
            numAaa[i] = numBbb[i];
            numBbb[i] = temp;

        }*/

        // 방법 2 : 참조한 주소 변경
        int aaa[] = numAaa;
        int bbb[] = numBbb;

        int temp[] = aaa;
        aaa = bbb;
        bbb= temp;

        System.out.println(Arrays.toString(aaa));
        System.out.println(Arrays.toString(bbb));

    }
}
