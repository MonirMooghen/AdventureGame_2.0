public class MeleeWeapon extends Weapon{

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MeleeWeapon(String itemName, String itemDescription, int damage){
        super(itemName, itemDescription, damage, false);
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    @Override
    public int remainingUses(){
        return 1; //Returns 1, because it will always have 1 attack left (never runs out)
    }

    @Override
    public void useWeapon(){
    }//is empty because it does not need to reduce ammo...

    //------------------------------------------------------------------------------------------------------------------
}
