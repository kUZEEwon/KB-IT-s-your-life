public class MainClass {

    public static void main(String[] args) {
        /*
        * 조건문
        * - if
        * - else
        *
        * - if
        * - else if
        * - else
        *
        * 부등호, 등호       > < >= <= == !=
        * 논리 연산자        &&(AND), ||(OR), !(NOT)
        *
        * if(조건){
        * 처리
        * }
        * */

        int num = 6;

        if(num == 6){
            System.out.println("This is 6");
        }

        if(num >= 6){
            System.out.println("This is 6");
        }

        if(num < 10){
            System.out.println("10 보다 작다");
        }

        if(num > 0 && num < 10){
            System.out.println("num은 0보다 크고 10보다 작다.");
        }

        if(num > 10 || num < 100){
            System.out.println("num은 10보다 크거나 100보다 작다.");
        }

        if(!(num > 10 || num < 100)){ // num <= 10 && num >=100
            System.out.println("num > 10 || num < 100");
        }

        // else
        if(num > 100){
            System.out.println("num > 100");
        }else{
            System.out.println("num < 100");
        }

        // 삼항 연산자
        // 값 = (조건) ? "값1":"값2"
        int myNum = 1024;
        if(myNum == 1024){
            System.out.println("정답");
        }else{
            System.out.println("틀린 답");
        }

        String s = (myNum == 1024) ? "정답":"틀린답";
        System.out.println(s);

        // 조건 분기
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
            System.out.println("재시험");
        }

        // 조건문 안에 조건문
        if(count > 90){
            if(count > 95){
                System.out.println("A+ 입니다");
            }else{
                System.out.println("A 입니다");
            }
        }

        // Switch
        char c = 'A';

        switch (c){
            case 'A':
                System.out.println("A");
                break;
            case 'B':
                System.out.println("B");
                break;
            default: //else

        }
    }

}
