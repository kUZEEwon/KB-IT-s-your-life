public class Three {
    public void threeMethod(){
        SingletonClass sc = SingletonClass.getInstance();

        System.out.println("여기는 ThreeClass");
        System.out.println(sc.number);
        System.out.println(sc.name);
    }
}
