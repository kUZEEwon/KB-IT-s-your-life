
public class MainClass {

    public static void main(String[] args) {
        /*
            조건문
            - if
            - else

            - if
            - else if
            - else

            부등호, 등호     > < >= <= == !=
            논리연산자       &&(AND), ||(OR), !(NOT)

            if(조건){
                처리
            }
        */

        int number = 6;

        if(number == 6){
            System.out.println("The number is 6");
        }

        if(number >= 6){
            System.out.println("The number is 6");
        }
        
        if(number < 10){
            System.out.println("10 보다 작다");
        }

        if(number > 0 && number < 10){
            System.out.println("number는 0보다 크고 10보다 작다");
        }
        if(number > 10 || number < 100){
            System.out.println("number는 10보다 크거나 100보다 작다");
        }

        if(!(number > 10 || number < 100)){ // number <= 10 && number >= 100
            System.out.println("number > 10 || number < 100");
        }

        // else
        if(number > 100){
            System.out.println("number > 100");
        }else{
            System.out.println("number < 100");
        }

        int myNumber = 1024;

        if(myNumber == 1024){
            System.out.println("정답");
        }else{
            System.out.println("틀린답");
        }

        // 삼항연산자  == if else
        // 값 = (조건) ? "값1":"값2";
        String s = (myNumber == 1024) ? "정답":"틀린답";
        System.out.println(s);


        // 조건분기
        int count = 90;
        if(count == 100){
            System.out.println("A+입니다");
        }
        else if(count >= 90){
            System.out.println("A입니다");
        }
        else if(count >= 80){
            System.out.println("B입니다");
        }
        else if(count >= 70){
            System.out.println("C입니다");
        }
        else{
            System.out.println("재시험입니다");
        }

        // 조건문 안에 조건문
        if (count > 90){
            if(count >= 95){
                System.out.println("A+입니다");
            }else {
                System.out.println("A입니다");
            }
        }

        // switch
        char c = 'A';

        switch (c){
            case 'A':   // if(c == 'A')
                System.out.println("A");
                break;
            case 'B':   // else if(c == 'B')
                System.out.println("B");
                break;
            default:    // else
        }

        /*
        double d = 12.3;
        switch (d){
            case 12.3:
                break;
        }*/

    }

}
