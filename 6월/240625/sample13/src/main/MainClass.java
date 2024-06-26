package main;

import cls.ChildClass;
import Number.TwoClass;

public class MainClass {
    public static void main(String[] args) {
//        MyClass cls = new MyClass();
//        System.out.println(cls);

        //MyClass2 cls1 = new MyClass2();

//        ChildClass cc = new ChildClass();
//        cc.parent_x = 123;
//        cc.child_function();
//
//        cc.child_x = 234;
//        cc.ParentMethod();


        /*
        * private : 개인적인
        * public : 대중적인
        * protected : 보호하다
        * */
        ChildClass child = new ChildClass();


        TwoClass tc = new TwoClass();
        TwoClass tc2 = new TwoClass("jiwon");



    }
}

/*class MyClass {

}

class MyClass2 {

}*/
