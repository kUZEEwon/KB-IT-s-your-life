package animal.animal;

import animal.Animal;

public class Cow implements Animal {
    @Override
    public void printDescript() {
        System.out.println("황소 입니다.");
    }

    public void cowMethod(){
        System.out.println("음메헤 음메헤");
    }
}
