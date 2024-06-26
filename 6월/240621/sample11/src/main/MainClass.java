package main;

import cls.Human;
import cls.MyClass;
import tv.TVClass;

public class MainClass {
    public static void main(String[] args) {
        /* oop의 3대 요소
        * 은닉성   => 캡슐화
        * 상속성
        * 다형성
        * */


        // TV
       /* boolean power[] = new boolean[3];
        int channel [] = new int[3];
        int[] volume = new int[3];

        for (int i = 0; i < 3; i++) {
            power[i] = false;
            channel[i] = 0;
            volume[i] = 0;
        }


        power[1] = true;
        channel[1] = 11;
        volume[1] = 3;

        for (int i = 0; i < power.length; i++) {
            tvInfo(power[i], channel[i], volume[i]);
        }

        System.out.println("============Class로 구현================");

        TVClass tv1 = new TVClass();
        TVClass tv2 = new TVClass();
        TVClass tv3 = new TVClass();

        //  tv1.power <= power가 public이 아니라서 외부 패키지에서 접근이 안됨(은닉성)
        tv1.setTV(false, 0, 0);
        tv2.setTV(false, 0, 0);
        tv3.setTV(false, 0, 0);

        tv2.setTV(true, 3, 11);

        tv1.tvInfo();
        tv2.tvInfo();
        tv3.tvInfo();


        System.out.println("================객체 배열로 구현===================");
        // 객체 배열
        // 배열 선언
        TVClass arrTv[] = new TVClass[3];   // 배열 만 생성함
        //  TVClass tv1, tv2, tv3 와 동일


        // 동적 할당
        for (int i = 0; i < arrTv.length; i++) {
            arrTv[i] = new TVClass();
            arrTv[i].setTV(false, 0, 0);
        }

        arrTv[1].setTV(true, 3, 11);

        for (int i = 0; i < arrTv.length; i++) {
            arrTv[i].tvInfo();
        }
*/
        MyClass cls = new MyClass();
//        cls.number =1;
//        cls.name = "홍길동";
//        cls.age = 24;

        cls.setNumber(1);
        int number = cls.getNumber();

        System.out.println("number is " + number);
        cls.method();

        Human human = new Human();
        System.out.println(human);

        System.out.println(human.method());
    }

    static void tvInfo(boolean pow, int ch, int vol){
        System.out.println(pow + " " + vol + " " + ch);
    }
}
