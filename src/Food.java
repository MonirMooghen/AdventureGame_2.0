public class Food extends Item {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private int healthPoints;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Food(String itemName, String itemDescription, int healthPoints){
        super(itemName, itemDescription);
        this.healthPoints = healthPoints;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public int getHealthPoints() {
        return healthPoints;
    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    //------------------------------------------------------------------------------------------------------------------
}
