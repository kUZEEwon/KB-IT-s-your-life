package factory;

import animal.Animal;
import animal.animal.Cat;
import animal.animal.Cow;
import animal.animal.Dog;

public class AnimalFactory {

    public static Animal createAnimal(String animalType){
        if(animalType.equals("")){
            System.out.println("생성할 클래스가 없어요.");
        }
        else if(animalType.equals("멍멍이")){
            return new Dog();
        }
        else if(animalType.equals("야옹이")){
            return new Cat();
        }
        else if(animalType.equals("황소")){
            return new Cow();
        }


        // 생성할 클래스가 없을 때
        return null;

    }
}
