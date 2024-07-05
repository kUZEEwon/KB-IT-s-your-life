package type;

import bomb.Bomb;
import bomb.Dynamite;
import weapon.Gun;
import weapon.Weapon;

public class Atype implements Types {
    @Override
    public Weapon createWeapon() {
        return new Gun();
    }

    @Override
    public Bomb createBomb() {
        return new Dynamite();
    }
}
