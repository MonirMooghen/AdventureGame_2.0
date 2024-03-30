import java.util.Scanner;

public class UserInterface {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Scanner inputScanner;
    private Adventure adventure;
    private boolean isProgramRunning;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    //Hvad bruges konstruktøren her til når den ikke bliver kaldt?
    public UserInterface() {
        adventure = new Adventure();
        inputScanner = new Scanner(System.in);
        inputScanner.useDelimiter("\n"); // Scanner bug solution
    }

    //***STARTPROGRAM***------------------------------------------------------------------------------------------------
    //Hvorfor er der ikke er et Adventure i vores start program/ hvordan ved programmet at der skal starte et nyt adventure?
    public void startProgram() {

        introduction();
        helpCommands();

        while (true) {
            if (isProgramRunning) {
                isProgramRunning = true;
            } else {
                userInput();
            }
        }
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public void newGame() {
        System.out.println("✦✦✦✦✦✦ WELCOME TO THE ADVENTURE GAME ✦✦✦✦✦✦");
        System.out.println("_______________________________________________");
        System.out.println("|      NEW GAME      - Starts a new game      |");
        System.out.println("|      EXIT          - Exits the program      |");
        System.out.println("-----------------------------------------------");
        String userInput = inputScanner.nextLine();
        boolean exit = false; //added for at se om loopet stopper

        while (!(userInput.isEmpty())) {
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                System.exit(0); //hvorfor 0?
                exit = true;
            } else if (userInput.equalsIgnoreCase("new game")) {
                System.out.println("Starting new game...");
                startProgram();
            } else {
                System.out.println("*** Input invalid *** \nPlease enter NEW GAME to start game or EXIT to end the program");
                userInput = inputScanner.nextLine();
            }
        }
    }

    public void introduction() {
        System.out.println("Hello, and welcome to .....");

        System.out.println("  ______               ___            _ _   _                             ");
        System.out.println(" |  ____|             / _ \\          | | | | |                            ");
        System.out.println(" | |__ ___  __ _ _ __/ /_\\ \\_ __   __| | |_| |_   _ _ __   __ _  ___ _ __ ");
        System.out.println(" |  __/ _ \\/ _` | '__|  _  | '_ \\ / _` |  _  | | | | '_ \\ / _` |/ _ \\ '__|");
        System.out.println(" | | |  __/ (_| | |  | | | | | | | (_| | | | | |_| | | | | (_| |  __/ |   ");
        System.out.println(" |_|  \\___|\\__,_|_|  \\_| |_|_| |_|\\__,_|_| |_|\\__,_|_| |_|\\__, |\\___|_|   ");
        System.out.println("                                                           __/ |          ");
        System.out.println("                                                          |___/           ");

        System.out.println("This is a horror survival game");
        System.out.println("Try and survive while discovering the secrets of the tomb");
        System.out.println("▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔\n");
        System.out.println("You find yourself at the entrance of a dark tomb. You don't remember anything");
    }

    public void helpCommands() {
        System.out.println("Commands:");
        System.out.println("GO <direction>  - Move in the specified direction (e.g., 'go north', 'go west'). You can also use N, S, E, and W.");
        System.out.println("LOOK            - Take another look around the room.");
        System.out.println("TAKE <item>     - Pick up an object from a room (e.g., 'take club').");
        System.out.println("DROP <item>     - Drop an item inside a room (e.g., 'drop club').");
        System.out.println("EAT <item>      - Consume an item in your inventory for health (e.g., 'eat apple').");
        System.out.println("EQUIP <weapon>  - Equips a weapon from your inventory (e.g., 'equip AK-47");
        System.out.println("INVENTORY       - View items in your inventory.");
        System.out.println("EXIT            - Exit the program.");
    }

    //------------------------------------------------------------------------------------------------------------------

    public void userInput() {
        String input = inputScanner.nextLine().trim().toLowerCase();
        String[] commands = input.split("\\s+");
        String command = commands[0];


        if (commands.length == 1) {
            switch (command) {
                //-> lambda expression  og gør så der ikke skal break; på.
                case "help", "h" -> {
                    helpCommands();
                }
                case "look" -> {
                    System.out.println("On the floor you see: ");
                    adventure.printItemList();
                    System.out.println("In the room you also notice: ");
                    adventure.printEnemyList();

                }
                case "inventory" -> {
                    System.out.println(adventure.getPlayer().getInventoryList());
                }
                case "attack" -> {
                    // Handle attack command without specifying an enemy
                    String attackMessage = adventure.getPlayer().attack(null); // Call attack method without parameters
                    System.out.println(attackMessage);

                }
                case "exit" -> {
                    System.exit(0);
                }
                default -> System.out.println("Invalid input");
            }

        }
        if (commands.length == 2) {
            switch (commands[0]) {

                case "go" -> {
                    switch (commands[1]) {
                        case "north", "n" -> {
                            adventure.goNorth();
                        }
                        case "south", "s" -> {
                            adventure.goSouth();
                        }
                        case "east", "e" -> {
                            adventure.goEast();
                        }
                        case "west", "w" -> {
                            adventure.goWest();
                        }
                        default -> System.out.println("Invalid input");
                    }
                }

                case "take" -> {
                    Item pickItem = adventure.takeItem(commands[1]);
                    if (pickItem != null) {
                        System.out.println("Picked up '" + pickItem + "'");
                    } else {
                        System.out.println("There is no " + commands[1] + " in this room.");
                    }
                }

                case "drop" -> {
                    Item dropItem = adventure.dropItemPlayer(commands[1]);
                    if (dropItem != null) {
                        System.out.println("Dropped '" + dropItem + "'");
                    } else {
                        System.out.println("There is no " + commands[1] + " in your inventory");
                    }
                }

                case "eat" -> {
                    String eatMessage = adventure.eatFood(commands[1]);
                    System.out.println(eatMessage); // This will print the result of eating the food, e.g., "You ate the apple."
                }

                case "equip" -> {
                    String equipMessage = adventure.equipWeapon(commands[1]);
                    System.out.println(equipMessage);
                }

                case "attack" -> {
                    String attackMessage = adventure.attackMethod(commands[1]);
                    System.out.println(attackMessage);
                }
            }
        }
    }
}