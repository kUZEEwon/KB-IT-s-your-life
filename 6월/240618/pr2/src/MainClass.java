import java.util.Arrays;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int arr1[] = new int[10];
        int arr2[] = new int[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            arr1[i] = rand.nextInt(50);
            arr2[i] = rand.nextInt(50)+50;
        }
        System.out.println("배열 1: " + Arrays.toString(arr1));
        System.out.println("배열 2: " + Arrays.toString(arr2));

        int arr[] = new int[arr1.length+ arr2.length];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);

        // 중복값 제거
        int unique[] = new int[arr1.length+ arr2.length];
        int j=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] != arr[i+1]) {
                unique[j++] = arr[i];
            }
        }
        unique[j++] = arr[arr.length-1];

        int[] result = new int[unique.length];
        System.arraycopy(unique, 0, result, 0, unique.length);
        System.out.println("중복값 제거: " + Arrays.toString(result));

        // max
        int max = -2;
        int max_index = -9;

        int min = 522;
        int min_index = -1;

        for(int i=0;i<result.length;i++) {
            if(result[i] > max) {
                max = result[i];
                max_index = i;
            }
        }

        for(int i=0;i<result.length;i++) {
            if(result[i] < min) {
                min = result[i];
                min_index = i;
            }
        }

        System.out.println("최댓값 : " + max);
        System.out.println("최솟값 : " + min);
        System.out.println("최댓값 위치 : " + max_index);
        System.out.println("최솟값 위치 : " + min_index);


    }
}
