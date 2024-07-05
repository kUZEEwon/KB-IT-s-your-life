import animal.Animal;
import animal.animal.*;
import factory.AnimalFactory;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        /*
        * Factory Pattern : 공장형, 원하는대로 쉽게 (다수)객체를 생성
        *
        * */

        Animal ani1 = AnimalFactory.createAnimal("멍멍이");
        Animal ani2 = AnimalFactory.createAnimal("야옹이");
        Animal ani3 = AnimalFactory.createAnimal("황소");

        ani1.printDescript();
        ani2.printDescript();
        ani3.printDescript();

       Dog dog= (Dog) ani1;
       dog.dogMethod();
        System.out.println();

        Cat cat = (Cat) ani2;
        cat.catMethod();
        System.out.println();

        Cow cow = (Cow) ani3;
        cow.cowMethod();


        // 동물을 생성
        String animalName[] = {"멍멍이","멍멍이","멍멍이", "야옹이", "야옹이", "황소"};

        List<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < animalName.length; i++) {
            Animal animal = AnimalFactory.createAnimal(animalName[i]);
            animalList.add(animal);
        }

        for (Animal animal : animalList) {
            animal.printDescript();

            if(animal instanceof Dog){
               ((Dog) animal).dogMethod();
            }else if(animal instanceof Cat){
                ((Cat) animal).catMethod();
            }else if(animal instanceof Cow){
                ((Cow) animal).cowMethod();
            }
        }

    }
}
