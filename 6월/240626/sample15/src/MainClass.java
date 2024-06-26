public class MainClass {
    public static void main(String[] args) {
        // super
        Human human = new Human();
        human.breathe();
        System.out.println("=================================================");
        Biology bio = new Human();
        bio.breathe();
        ((Human)bio).breathe("딸기");
    }
}

class Biology {
    public void breathe(){
        System.out.println("숨을 쉽니다.");
    }
}

class Animal extends Biology {
    String food;

    public Animal() {
        food = "고기를 먹습니다";
    }

    public void breathe(){
        // OverRide
        super.breathe();

        System.out.println("움직입니다.");
    }
}

class Human extends Animal {
    String food;

    public Human(){
        food = "스테이크와 샐러드를 먹어요";
    }

    public void breathe(){
        super.breathe();
        System.out.println("이성적으로 생각합니다.");

        System.out.println(super.food);
        System.out.println(food);
    }

    public void breathe(String str){
        System.out.println(str + "을 먹어요");
    }
}