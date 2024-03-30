public class RangedWeapon extends Weapon{

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    int ammo;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public RangedWeapon(String itemName, String itemDescription, int damage, int ammo){
        super(itemName, itemDescription, damage, true);
        this.ammo = ammo;
    }

    //***METHODS***  ---------------------------------------------------------------------------------------------------
    @Override
    public int remainingUses(){
        return ammo;
    }

    // -- means -1
    @Override
    public void useWeapon(){
        ammo--;
    }

    //-------------------------------------------------------------------------------------------------------------------
}
