public class Human extends Object {

    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println(name +"(이)가 밥을 먹습니다.");
    }

}
