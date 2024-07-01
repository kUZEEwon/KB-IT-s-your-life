import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws FileNotFoundException {
/*
        Animal ani[] = new Animal[10];

        ani[0] = new Dog();
        ani[1] = new Dog();
        ani[2] = new Duck();
        ani[3] = new Cat();
        ani[4] = new Duck();
        ani[5] = new Cat();


        // Object로 어떠한 클래스도 묶을 수 있다.
        Object obj[] = new Object[5];
        obj[0] = new Car(); // up cast
        obj[1] = new Bus();

        Car car = (Car)obj[0]; // down cast
        car.counter();
*/


        /*
         * Exception     예외  != 에러
         *
         * number format 1 ~ ... =>
         * array index bounds  array[3] -> number[3]
         * class not found
         * file not found
         *
         *
         * try {
         *   예외가 나올 가능성이 있는 코드1
         *   예외가 나올 가능성이 있는 코드1
         * }catch(예외클래스 e){
         *   메시지
         * }catch(예외클래스2 e){
         *   메시지
         * }finally{
         * 무조건 실행
         *   // 뒷처리 close, rollback
         *}
         *
         *
         * */

        /*int array[] = {1,2,3};
        System.out.println("프로그램 시작");
        try{
            for(int i=0;i<5;i++){
                System.out.println(array[i]);
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("배열 범위 초과");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("프로그램 끝");
        }
        System.out.println("프로그램 끝");

        myFunction();

        try{
            myFunction2();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }
*/
        // 자주 볼 수 있는 Exception

        //1. Null Pointer  Exception


        String str = null;  // #define (0x00) NULL 객체 초기화

        try{
            System.out.println(str.length());
        }catch (NullPointerException e){
            System.out.println("객체 할당 전");
            e.printStackTrace();
        }

        //2. ArrayIndexOutOfBoundsException
        int array[] = {1,2,3};
        try{
            System.out.println(array[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }


        //3. FileNotFoundException
        File file = new File("c:\\xxx.txt");
        FileInputStream is;

        try{
            is = new FileInputStream(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //4. NumberFormatException
        int num1;

        try{
            num1 = Integer.parseInt("12.32");
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        //5. StringIndexOutBoundsException
        String str1 = "abc";


        try{
            char c = str1.charAt(3);
        }catch (StringIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


        // 입력 -> 숫자. 문자 -> 예외

        String str2 = "dsnl";
        boolean result = true;
        for (int i = 0; i < str2.length(); i++) {
            int asc = (int)str2.charAt(i);
            if(asc<48 || asc>57){
                result = false;
                break;
            }
        }

        if(result) System.out.println("숫자입니다");
        else System.out.println("문자가 있습니다");

        int number;
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("숫자 입력 = ");
                number = sc.nextInt();
                break;
            }catch (InputMismatchException e){
                e.printStackTrace();
                System.out.println("숫자가 아닙니다. 다시 입력해 주세요.");
            }
        }




    }

    public static void myFunction() {
        int array[] = {1, 2, 3};
        System.out.println("프로그램 시작");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(array[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();

        }
    }

    public static void myFunction2() throws ArrayIndexOutOfBoundsException {
        int array[] = {1, 2, 3};
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
    }
}

class Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}

class Duck extends Animal {

}


class Car extends Object {
    // Object : 포인터를 저장할 수 있는 객체
    public void counter() {
        System.out.println("Car Count");
    }

}

class Bus extends Object {

}