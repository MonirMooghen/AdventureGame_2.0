import java.util.ArrayList;
import java.util.Random;

public class Player {

    ///***ATTRIBUTES***-------------------------------------------------------------------------------------------------
    private Room currentRoom;
    private ArrayList<Item> inventoryList;
    private int healthPointsPlayer;
    private Weapon currentWeapon;
    private boolean isPlayerDead;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    //Hvorfor er player firstRoom?
    public Player(Room firstRoom){
        this.currentRoom = firstRoom;
        this.inventoryList = new ArrayList<>();
        this.healthPointsPlayer = 100;
        isPlayerDead = false; //hvorfor ikke (this.)?
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public ArrayList<Item> getInventoryList(){
        return inventoryList;
    }

    public int getHealthPointsPlayer(){
        return healthPointsPlayer;
    }

//    public Weapon getCurrentWeapon(){
//        return currentWeapon;
//    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setHealthPointsPlayer(int healthPointsPlayer){
        this.healthPointsPlayer = healthPointsPlayer;
    }

    //***METHODS***(so player can move around in different rooms)-------------------------------------------------------
    public void MovePlayerNorth(){
        if(currentRoom.getNorthConnection() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getNorthConnection(); //Uses getter method to set the new currentRoom to the Room which is North from CurrentRoom.
            System.out.println("going north");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void MovePlayerSouth(){
        if(currentRoom.getSouthConnection() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getSouthConnection(); //Uses getter method to set the new currentRoom to the Room which is South from CurrentRoom.
            System.out.println("going south");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void MovePlayerEast(){
        if(currentRoom.getEastConnection() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getEastConnection(); //Uses getter method to set the new currentRoom to the Room which is East from CurrentRoom.
            System.out.println("going east");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void MovePlayerWest(){
        if(currentRoom.getWestConnection() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getWestConnection(); //Uses getter method to set the new currentRoom to the Room which is West from CurrentRoom.
            System.out.println("going west");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    //***METHODS--------------------------------------------------------------------------------------------------------
    public void currentRoomPrint(){
        System.out.println(currentRoom.getRoomName() + " " + currentRoom.getRoomDescription());
    }

    public void directionNotPossible(){
        System.out.println("You cannot go this direction");
    }

    public Item findItemInInventory(String itemName){
        for (Item item : inventoryList) { //For loop checks if the itemName is within the arraylist of inventory
            if (item.getItemName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }

    public void addItemPlayer(Item item){
        inventoryList.add(item);
    }

    public void removeItem(Item item) {
        inventoryList.remove(item);
    }

    public Item dropItem(String itemName) {
        Item pickedItem = findItemInInventory(itemName);
        if (pickedItem != null) {
            removeItem(pickedItem);
            getCurrentRoom().addItemRoom(pickedItem);
        }
        return pickedItem;
    }

    public Item takeItem(String itemName) {
        Item pickedItem = getCurrentRoom().removeItem(itemName);
        addItemPlayer(pickedItem);
        return pickedItem;
    }

    public String eatFood(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item == null) {
            return "You don't have " + itemName + " in your inventory.";
        } else if (item instanceof Food food) { //make separate variable on top...
            if (healthPointsPlayer + food.getHealthPoints() >= 100) {
                setHealthPointsPlayer(100);
                removeItem(food);
                return "You ate the " + itemName + " and now have" + getHealthPointsPlayer() + " health";
            } else {
                removeItem(food);
                healthPointsPlayer += food.getHealthPoints();
                return "You ate the " + itemName;
            }
        } else {
            return "You cannot eat the " + itemName;
        }
    }

    //Not sure exactly how this works logically/practically...->
    public String equipWeapon(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item == null) {
            return "You don't have that item.";
        } else if (item instanceof Weapon) {
            currentWeapon = (Weapon) item;
            inventoryList.remove(item);
            return "You have equipped " + item.getItemName() + ".";
        } else {
            return "You can't equip " + item.getItemName() + ".";
        }
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

//    public void attack(String enemyName) {
//        Enemy enemy = currentRoom.searchEnemy(enemyName);
//
//        if (currentWeapon == null) {
//            System.out.println("\"You need a weapon to attack\"");
//
//        } else if (currentWeapon.remainingUses() > 0){
//            if (!(enemy == null)) {
//                enemy.getHealthPointsEnemy();
//                currentWeapon.getDamage();
//
//            }
//        }
//    }



//    public String attack(String enemyName) {
//        if (currentWeapon == null) {
//            return "You need to have a weapon equipped to attack.";
//        }
//
//        if (currentWeapon.remainingUses() <= 0) {
//            return "Your " + currentWeapon.getItemName() + " has no ammo left. Equip another weapon";
//        }
//
//        Enemy enemy = currentRoom.searchEnemy(enemyName);
//        if (enemy == null) {
//            return "No enemy by that name is in the room.";
//        }
//
////        if (currentRoom.getEnemyList().isEmpty()) { //så spilleren kan attacke luften
////            currentWeapon.useWeapon();
////            return "No enemy is in the room. You attack the air, wasting your effort. " +
////                    "Your weapon has " + currentWeapon.remainingUses() + " uses left.";
////        }
////
////        // Attack the enemy
////        currentWeapon.useWeapon();
////        enemy.receiveDamage(currentWeapon.getDamage()); //kalder på recievedamage metoden fra enemy klassen, som
////        // gør skade på enemy objektet. derefter tager den damage fra det current våbens damage
//
//        // Check if there are enemies in the current room
//        if (currentRoom.getEnemyList().isEmpty()) {
//            // Attack the air if no enemies are present
//            currentWeapon.useWeapon();
//            return "You attack the empty air, accomplishing nothing. " +
//                    "Your weapon has " + currentWeapon.remainingUses() + " uses left.";
//        } else {
//            // Select a random enemy to attack if enemies are present
//            Random rand = new Random();
//            Enemy randomEnemy = currentRoom.getEnemyList().get(rand.nextInt(currentRoom.getEnemyList().size()));
//
//            // Attack logic for the selected enemy
//            currentWeapon.useWeapon();
//            enemy.receiveDamage(currentWeapon.getDamage()); //kalder på recievedamage metoden fra enemy klassen, som
////        // gør skade på enemy objektet. derefter tager den damage fra det current våbens damage
//            return "You attack the closest enemy, " + randomEnemy.getEnemyName() + ". " +
//                    "It now has " + randomEnemy.getHealthPointsEnemy() + " health left!";
//
//        if (enemy.isEnemyDead()) {
//            currentRoom.removeEnemyRoom(enemy);
//            currentRoom.addItemRoom(enemy.dropWeapon());
//            return "You have slain the " + enemy.getEnemyName() +
//                    ". On the floor they have dropped " + enemy.dropWeapon().getItemDescription();
//        } else {
//            // If enemy is not dead, it hits back
//            String hitResult = enemy.hit(this);
//            String attackResult = "You attacked the " + enemy.getEnemyName() +
//                    ". It now has " + enemy.getHealthPointsEnemy() + " health left! \n" ;
//            // Combine the results from the attack and the enemy's hit
//            return attackResult + "\n" + hitResult;
//        }
//    }

    public String attack(String enemyName) {
        if (currentWeapon == null) {
            return "You need to have a weapon equipped to attack.";
        }

        if (currentWeapon.remainingUses() <= 0) {
            return "Your " + currentWeapon.getItemName() + " has no ammo left. Equip another weapon.";
        }

        // Check if an enemy name was not provided and room is empty or has enemies
        if (enemyName == null || enemyName.isEmpty()) {
            if (currentRoom.getEnemyList().isEmpty()) {
                currentWeapon.useWeapon();
                return "You attack the empty air, accomplishing nothing. " +
                        "Your weapon has " + currentWeapon.remainingUses() + " uses left."; //forekommer dog også med melee våben
            } else {
                // Randomly select an enemy if the room has enemies
                Random rand = new Random();
                Enemy randomEnemy = currentRoom.getEnemyList().get(rand.nextInt(currentRoom.getEnemyList().size()));
                currentWeapon.useWeapon();
                randomEnemy.receiveDamage(currentWeapon.getDamage());

                if (randomEnemy.isEnemyDead()) {
                    currentRoom.removeEnemyRoom(randomEnemy);
                    currentRoom.addItemRoom(randomEnemy.dropWeapon());
                    return "You have slain the " + randomEnemy.getEnemyName() +
                            "\nOn the floor they have dropped " + randomEnemy.dropWeapon().getItemDescription();
                } else {
                    //If enemy is not dead, it hits back
                    String hitResultRandom = randomEnemy.hit(this);
                    String attackResultRandom = "You attacked the " + randomEnemy.getEnemyName() +
                            ". It now has " + randomEnemy.getHealthPointsEnemy() + " health left!" ;
                    // Combine the results from the attack and the enemy's hit
                    return attackResultRandom + "\n" + hitResultRandom;

                }
            }
        } else {
            // Method for attacking a specified enemy
            Enemy enemy = currentRoom.searchEnemy(enemyName);
            if (enemy == null) {
                return "No enemy by that name is in the room.";
            } else {
                currentWeapon.useWeapon(); //uses the weapon
                enemy.receiveDamage(currentWeapon.getDamage()); // Apply damage to enemy

                if (enemy.isEnemyDead()) {
                    currentRoom.removeEnemyRoom(enemy);
                    currentRoom.addItemRoom(enemy.dropWeapon());
                    return "You have slain " + enemyName +
                            "\nOn the floor they have dropped " + enemy.dropWeapon().getItemDescription();

                } else {
                    //If enemy is not dead, it hits back
                    String hitResult = enemy.hit(this);
                    String attackResult = "You attacked the " + enemy.getEnemyName() +
                            ". It now has " + enemy.getHealthPointsEnemy() + " health left!" ;
                    // Combine the results from the attack and the enemy's hit
                    return attackResult + " " + hitResult;
                }
            }
        }
    }


    public void receiveDamage(int damage) { //metode til at modtage skade fra enemy
        this.healthPointsPlayer -= damage;
        if (this.healthPointsPlayer <= 0) {
            this.isPlayerDead = true;
        }
    }

    public boolean isPlayerDead(){
        return getHealthPointsPlayer() <= 0;
    }

    //------------------------------------------------------------------------------------------------------------------
}
