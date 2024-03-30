//ADVENTURE CLASS - CONTROLLER OF THE CLASSES (INFORMATION EXPERT)
public class Adventure {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Player player;
    private Map map = new Map();

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Adventure(){
        map.mapCreator();
        player = new Player(map.getStarterRoom());
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------

    public Player getPlayer() {
        return player;
    }

    public void getPlayerCurrentRoomPrint(){
        player.currentRoomPrint();
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    //Not sure why this doesn't work...
//     public String getAddItemPlayer(String itemName) {
//        return player.addItemPlayer(itemName);
//     }

//     public String getPlayerEat(String itemName) {
//        return player.eatFood(itemName);
//     }

    public String equipWeapon(String itemName) {
        return player.equipWeapon(itemName);
    }

    public Item takeItem(String shortName) {
        return player.takeItem(shortName);
    }

    public Item dropItemPlayer(String itemName) {
        return player.dropItem(itemName);
    }

    public String eatFood(String itemName) {
        return player.eatFood(itemName);
    }

    public boolean isPlayerDead() {
        return player.isPlayerDead();
    }



    //***METHODS*** (that makes the player move to a given direction)----------------------------------------------------
    public void goNorth(){
        player.MovePlayerNorth();
    }

    public void goSouth(){
        player.MovePlayerSouth();
    }

    public void goEast(){
        player.MovePlayerEast();
    }

    public void goWest(){
        player.MovePlayerWest();
    }



    //------------------------------------------------------------------------------------------------------------------

    public void printEnemyList() {
        getCurrentRoom().printEnemyList();
    }

    public void printItemList() {
        getCurrentRoom().printItemlist();
    }
    //------------------------------------------------------------------------------------------------------------------

    public String attackMethod(String enemyName) {
        return player.attack(enemyName);
    }
}
