public abstract class Weapon extends Item {

    //In Java we have the reserved word Abstract, which is a non access modifier that can be used on classes and methods.
    // It is used when you want to define a template for a class or method, but do not intend for it to be used as is.
    //An abstract class is not designed to be instantiated. It's designed to be extended, thus pushing the burden of
    // implementation onto the subclasses.

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private int damage;
    private boolean isRangedWeapon;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Weapon(String itemName, String itemDescription, int damage, boolean isRangedWeapon){
        super(itemName, itemDescription);
        this.damage = damage;
        this.isRangedWeapon = isRangedWeapon;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public int getDamage() {
        return damage;
    }

    public boolean getIsRangedWeapon() {
        return isRangedWeapon;
    }

    //***ABSTRACT METHODS/SIGNATURES***---------------------------------------------------------------------------------
    // Abstract methods is designed to be overwritten by a subclass, meaning methods are inherited from the subclasses
    //Thus the hierarchical logic is reversed...
    public abstract int remainingUses();

    public abstract void useWeapon();

    //------------------------------------------------------------------------------------------------------------------
}
