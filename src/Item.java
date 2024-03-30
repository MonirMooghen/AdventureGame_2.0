public class Item {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String itemName;
    private String itemDescription;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Item(String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    //ToString (if you print any kind og object, java prints out the memory place and not the object information)...
    //Unless you Override the function with a toString() method.
    @Override
    public String toString() {
        return itemDescription;
    }

    //------------------------------------------------------------------------------------------------------------------
}
