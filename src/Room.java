import java.util.ArrayList;

public class Room {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String roomName;
    private String roomDescription;

    private Room northConnection;
    private Room southConnection;
    private Room eastConnection;
    private Room westConnection;

    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Enemy> enemyList = new ArrayList<>();


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Room (String roomName, String roomDescription){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    //***SETTER METHODS (to set the value)***---------------------------------------------------------------------------
    public void setNorthConnection(Room northConnection){
        this.northConnection = northConnection;
    }
    public void setSouthConnection(Room southConnection){
        this.southConnection = southConnection;
    }
    public void setEastConnection(Room eastConnection){
        this.eastConnection = eastConnection;
    }
    public void setWestConnection(Room westConnection){
        this.westConnection = westConnection;
    }

    //***GETTER METHODS (so we can retrieve the value in other classes)***----------------------------------------------
    public Room getNorthConnection() {
        return northConnection;
    }
    public Room getSouthConnection() {
        return southConnection;
    }

    public Room getEastConnection() {
        return eastConnection;
    }

    public Room getWestConnection() {
        return westConnection;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    //***METHODS THAT RELATES TO ROOM***--------------------------------------------------------------------------------

    //***ITEM METHODS***------------------------------------------------------------------------------------------------
    //Hvad sker der når man kalder en klasse (fx Item) som datatyper inden i fx vores parameter?
    //bruger den så bare konstruktørens værdier/objekt)
    public void addItemRoom(Item addItem){
        itemList.add(addItem); //adds addItem to an <addItem>ArrayList
    }

    //Hvad sker der når man kalder en klasse i sin metode (i en anden klasse)?
    public Item searchItemRoom(String itemName) {
        for (Item item : itemList) {
            if(item.getItemName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }

    //Hvorfor kalder vi en String inde i vores i parameteret på vores Item metode?
    public Item removeItem(String itemName) {
        Item itemToRemove = searchItemRoom(itemName);
        itemList.remove(itemToRemove);
        return itemToRemove;
    }

    public void printItemlist() {
        for (Item item : itemList) {
            System.out.println(item);
        }
    }

    //***ENEMY METHODS--------------------------------------------------------------------------------------------------
    public Enemy addEnemyRoom(Enemy enemyName){
        enemyList.add(enemyName);
        return enemyName;
    }

    public void printEnemyList(){
        for (Enemy enemy : enemyList) {
            System.out.println(enemy);
        }
    }

    public void removeEnemyRoom(Enemy enemyName) {
        enemyList.remove(enemyName);
    }

    public Enemy searchEnemy(String enemyName) {

        for (Enemy searchEnemy : enemyList) {
            if (searchEnemy.getEnemyName().equalsIgnoreCase(enemyName))
                return searchEnemy;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------------------------------
}
