package type;

import bomb.Bomb;
import bomb.C4;
import bomb.Dynamite;
import weapon.Gun;
import weapon.Sword;
import weapon.Weapon;

public class Btype implements Types {

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Bomb createBomb() {
        return new C4();
    }
}
