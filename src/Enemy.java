public class Enemy {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String enemyName;
    private String enemyDescription;
    private int healthPointsEnemy;
    private boolean isEnemyDead;
    private Weapon weapon;
    private Room room;
    private int roomNumber;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Enemy(String enemyName, String enemyDescription, int healthPointsEnemy, Weapon weapon){
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.healthPointsEnemy = healthPointsEnemy;
        this.weapon = weapon;
        isEnemyDead = false;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------

    public String getEnemyName() {
        return enemyName;
    }

    public int getHealthPointsEnemy(){
        return healthPointsEnemy;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public boolean isEnemyDead(){ //Not sure this works, seems like isEnemyDead boolean is not accessed..
        return getHealthPointsEnemy() <= 0;
    }

    @Override
    public String toString(){ //Why toString here and what exactly does it Override?
        return enemyName;
    }

    public void receiveDamage(int damage) { //metode til at modtage skade fra player
        healthPointsEnemy -= damage; //hvorfor -=?
        if (healthPointsEnemy <= 0) {
            isEnemyDead = true;
        }
    }

    public String hit(Player player) { //hit metode til at gøre skade på player
        player.receiveDamage(this.weapon.getDamage());
        if (player.isPlayerDead()) {
            return "You have been killed by " + this.enemyName + ".";
        } else {
            return "The enemy strikes back with " + this.weapon.getItemName() + " causing " + this.weapon.getDamage() + " damage.\n" +
                    "You now have " + player.getHealthPointsPlayer() + " health.";
        }
    }

    public Weapon dropWeapon() {
        return this.weapon;
    }

    //------------------------------------------------------------------------------------------------------------------
}
