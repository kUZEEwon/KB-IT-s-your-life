import animal.AnimalInterface;
import animal.DogClass;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        /*
        * abstract class : 멤버 변수 + 멤버 메소드 + 추상 메소드
        *
        * interface : 추상 메소드. (멤버 메소드)
        *               다중 상속이 가능함
        *               빠르게 클래스의 구조를 파악할 수 있음
        *               확장성
        * */

        DogClass dog = new DogClass();
        dog.move();
        dog.eat();

        AnimalInterface ai2 = new DogClass();
        ai2.move();
        ai2.eat();
        ai2.live();


        List<String> list = new ArrayList<String>();
        Map<String, Object> hashMap = new HashMap<String, Object>();


    }
}

class One  {}
class Two {}


