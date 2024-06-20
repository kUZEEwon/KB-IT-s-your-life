import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        /*
        * Sorting : 정렬
        * 선택, 버블, 합병, Quick
        *
        *
        *
        * */

        // int numbers[] = {33, 1, 56, 32, 74, 21, 8, 46, 23, 65 ,9, 78, 10};
        Scanner sc = new Scanner(System.in);

        System.out.println("정렬할 수의 개수: ");
        int count = sc.nextInt();

        int numbers[]= new int[count];


        for (int i = 0; i < numbers.length; i++) {
            System.out.println((i+1) + "번째 수 : ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("오름(1)/내림(2) = ");
        int upDown = sc.nextInt();




        // sort
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(upDown == 1) {
                    if (numbers[i] > numbers[j]) { // 오름 차순
                        // swap
                        swap(numbers, i, j);
                    }
                }else{
                    if (numbers[i] < numbers[j]) { // 내림 차순
                        // swap
                        swap(numbers, i, j);
                    }
                }
            }
        }


        System.out.println(Arrays.toString(numbers));
    }

    

    static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
