import java.util.Arrays;

public class MainClass
{
    public static void main(String[] args) {
        /*
        * function: 함수, 독립적인 process
        * method: 함수, class에 소속되어 있는 함수, java, c#
        *
        * 목적: 코드의 간략화
        *       동일한 처리의 코드를 집약적으로 처리
        *
        * 형식:
        *       return value(자료형)   함수명(자료형 매개변수 ... ){
        *
        *               처리
        *
        *           return 값;       <- void일 경우는 필요 없다.
        *       }
        * */

        function();
        function2(123);     // 실인수  -> argument
        function3("지원",21.3);
        System.out.println(function4("23"));


        System.out.println(getAscii('A'));

        // value에 의한 할당
        int a =2;
        function5(a);
        System.out.println(a);

        // reference(주소)에 의한 할당
        int[] a1 = {2 };
        function6(a1);
        System.out.println(a1[0]);


        int arrNum[] = {10,20,30};

        // 2로 나눠서 출력하는 함수
        // 1. value
       /* for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = div(arrNum[i]);
        }*/

        // 2. reference
        div(arrNum);
        System.out.println("div " + Arrays.toString(arrNum));

        // 2차원 배열을 1차원 배열로 변환
        int Array[][]= {
                {1,2,3},
                {4,5,6,2,1,3},
                {7,8,9}
        };
        int one[] = new int[9];
        function7(one, Array);
        int arrayone[] = array2ToArray1_Stream(Array);
        System.out.println(Arrays.toString(one));
        System.out.println(Arrays.toString(arrayone));



        // 입력된 문자열이 모두 문자인지 확인하는 함수
        String s = "323";
        String result = isNumberic(s) ? "전부 숫자 입니다.":"문자가 포함되어 있어요.";
        System.out.println(result);

    }

    static void function(){
        System.out.println("function 호출");
    }

    static void function2(int a){
        System.out.println("function(int a) "+ a);
    }

    static void function3(String s, double d){
        System.out.println("function3(String s, double d) "+ s + ", " +d);
    }

    static int function4(String s){
        int number = Integer.parseInt(s);
        return number;
    }

    // ASCII 값을 return A -> 65
    static int getAscii(char c){
        return (int)c;
    }

    static void function5(int a){
        a= a*2;
        System.out.println("function5: "+a);
    }


    static void function6(int a[]){
        a[0] = a[0] * 2;
        System.out.println("function6: "+a[0]);
    }

    static int div(int n){
        return n/2;
    }


    // overload
    static void div(int arrNum[]){
        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = arrNum[i] /2;
        }
    }

    // 2차원 배열을 1차원 배열로
    static void function7(int[] oneArray, int[][] twoArray){
        int rows = twoArray.length;
        int cols = twoArray[0].length;

        int pos =0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                oneArray[pos] = twoArray[i][j];
                pos++;
            }
        }

        System.out.println("변환된 2차원 배열:\t"+Arrays.toString(oneArray));
    }

    static int[] flatten(int[][] arr2){
        // array.length
        // array[n].length: 묶음 안의 요소수(col)
        int rows = arr2.length;
        int cols = arr2[0].length;
        int array1[] = new int[rows * cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                array1[i * arr2[i].length + j] = arr2[i][j];
            }
        }

        return array1;

    }

    static int[] array2ToArray1_Stream(int[][] arr2){
        int array1[] = Arrays.stream(arr2).flatMapToInt(Arrays::stream).toArray();
        return array1;
    }

    // 입력된 문자열이 모두 숫자인지 확인하는 함수
    static boolean isNumberic(String s){
       /* boolean flag = false;
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                flag = true;
                break;
            }
        }
        return flag;*/

        // method 사용
        // return s.matches(".*\\d.*");

        // ASCII 코드 사용
        boolean flag = true;
        for (char c : s.toCharArray()) {
            int ascii = (int)c;
            if(ascii < 48 || ascii > 57){
                // 숫자가 없는 경우
                flag = false;
                break;
            }
        }
        System.out.println(flag);
        return flag;
    }



}
