package main;

import animal.Animal;
import animal.CatClass;
import animal.DogClass;
import cls.ChildClass;
import cls.ParentClass;

public class MainClass {
    public static void main(String[] args) {

      //  ChildClass child = new ChildClass();
      //  child.method();


        //
        ParentClass pc = new ChildClass();
        pc.method(); // override된 메소드가 호출된다.

        // cast 변환으로 pc.func 호출해보기
        ChildClass cc = (ChildClass) pc;
        cc.func();


        // animal3
        // 자식 클래스를 통합적으로 관리하기 위해
        Animal dog = new DogClass();
        Animal cat = new CatClass();

        dog.printDescript();
        cat.printDescript();

        // instanceof : 어떤 자식 클래스로 생성된 것인지 확인가능
        System.out.println(dog instanceof Animal);
        System.out.println(cat instanceof Animal);

        if(dog instanceof Animal) {
            DogClass dc = (DogClass) dog;
            dc.run();
        }else{
            CatClass cc1 = (CatClass) cat;
            cc1.eat();
        }

    }
}
