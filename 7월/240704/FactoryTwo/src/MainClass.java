import factory.MyCharacter;
import type.Atype;
import type.Btype;
import weapon.Sword;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        MyCharacter myChar = new MyCharacter();
        myChar.create(new Btype());

       // myChar.m_Weapon.drawWeapon();
       // myChar.m_Bomb.drawBomb();

        // List
        String strArr[] = {"Sword","Gun","Dynamite","C4"};
        List<MyCharacter> MyCharacters = new ArrayList<MyCharacter>();

        for(String s : strArr) {
            if(s.equals("Sword")) {
                myChar = new MyCharacter();
                myChar.create(new Btype());
                MyCharacters.add(myChar);
                myChar.m_Weapon.drawWeapon();

            }
            else if(s.equals("Gun")){
                myChar = new MyCharacter();
                myChar.create(new Atype());
                MyCharacters.add(myChar);
                myChar.m_Weapon.drawWeapon();
            } else if (s.equals("Dynamite")) {
                myChar = new MyCharacter();
                myChar.create(new Atype());
                MyCharacters.add(myChar);
                myChar.m_Bomb.drawBomb();
            }
            else if(s.equals("C4")) {
                myChar = new MyCharacter();
                myChar.create(new Atype());
                MyCharacters.add(myChar);
                myChar.m_Bomb.drawBomb();
            }
        }

        for(MyCharacter mc : MyCharacters) {
            mc.m_Weapon.drawWeapon();
            mc.m_Bomb.drawBomb();
        }


    }
}
