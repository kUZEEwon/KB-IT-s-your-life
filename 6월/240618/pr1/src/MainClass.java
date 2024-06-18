import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Random random = new Random();
        int array[] = new int[20];

        for(int i=0;i<20;i++){
            array[i] = random.nextInt(100)+1;
        }

        // 배열 전체 출력 : Arrays.toString(arr);
        System.out.println(Arrays.toString(array));

        int max = -9;
        int index = -1;
        for(int i=0;i<20;i++){
            if(array[i]>max){
                max = array[i];
                index = i;
            }
        }
        System.out.println("maximum value : " + max);
        System.out.println("index value : " + index);


        Arrays.sort(array); //배열 정렬(오름차순)
        // 최댓값 출력
        System.out.println("Array in ascending order : " + Arrays.toString(array));

        int reverse[] = new int[20];
        for(int i= array.length-1, j=0; i>=0; i--,j++){
            reverse[j] = array[i];
        } //배열 정렬(내림차순)
        System.out.println("Array in descending order : " + Arrays.toString(reverse));


        // 중복 제거
        int temp[] = new int[array.length];
        int j=0;
        for(int i=0;i< array.length-1;i++){
            if(array[i] != array[i+1]){
                temp[j++]=array[i];
            }
        }
        temp[j++] = array[array.length-1];

        int[] result = new int[j];
        System.arraycopy(temp,0,result,0,j);
        System.out.println("Unique Values: "+Arrays.toString(result));
        System.out.println("Count of unique Values: "+result.length);
    }
}
