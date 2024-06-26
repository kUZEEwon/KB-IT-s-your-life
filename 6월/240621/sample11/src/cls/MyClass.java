package cls;

/*
    접근 지정자
*   private : 개인적인
*   public  : 대중적인
*   protected  : (상속)특수한
*
*
* */

public class MyClass {
    // 변수 private
    private int number;
    private String name;
    private int age;

    // setter, getter => 함수

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 멤버 메소드 public
    public void method(){
        System.out.println("MyClass method()");
    }


}
