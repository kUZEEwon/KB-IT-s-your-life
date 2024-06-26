package animal;

public class DogClass extends Animal{
    public void printDescript(){
        System.out.println("멍멍멍 왈왈왈 왕!");
        run(); // 오버라이딩된 메소드 호출
    }
    public void run(){
        System.out.println("강아지 달리는 중");
    }
}
