package animal.animal;

import animal.Animal;

public class Cat implements Animal {
    @Override
    public void printDescript() {
        System.out.println("야옹이 입니다.");
    }

    public void catMethod(){
        System.out.println("야옹야옹");
    }
}
