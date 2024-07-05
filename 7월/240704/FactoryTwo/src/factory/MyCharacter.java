package factory;

import bomb.Bomb;
import weapon.Weapon;
import type.Types;

public class MyCharacter {
    public Weapon m_Weapon;
    public Bomb m_Bomb;

    public void create(Types type){
        m_Weapon = type.createWeapon();
        m_Bomb =type.createBomb();
    }
}
