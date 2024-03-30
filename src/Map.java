public class Map {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Room starterRoom;

    public void mapCreator() {
        //***OBJECTS (INSTANTIATES OBJECTS)***
        Room room1 = new Room("Room 1", "You find yourself at the entrance to a tomb. There are two doors.");
        Room room2 = new Room("Room 2", "You enter a maze. The light is dim.");
        Room room3 = new Room("Room 3", "You're in a basement with different torture instruments. In the back, there is a door.");
        Room room4 = new Room("Room 4", "You're in a big library, lit by candles");
        Room room5 = new Room("Room 5", "You enter a gallery with statues and paintings. You can't see a way out.");
        Room room6 = new Room("Room 6", "You go down a few steps, and step on a crunchy bone. It looks like a mass grave.");
        Room room7 = new Room("Room 7", "You're in a slim foyer. There's a latch visible. ");
        Room room8 = new Room("Room 8", "You slide down to a big dining hall. There are fresh meals on the table.");
        Room room9 = new Room("Room 9", "You're in a big laboratory. You hear screaming coming from the walls");

        starterRoom = room1;

        //ITEMS som går igen og kan dubleres
        Item apple = new Item("Apple", "A good looking apple");

        //ROOM1-------------
        room1.setEastConnection(room2);
        room1.setSouthConnection(room4);
        room1.addItemRoom(new Item("torch", "A long torch"));
        room1.addItemRoom(new Food("banana", "A healthy looking banana", 10));
        room1.addItemRoom(new RangedWeapon("AK-47", "An AK-47, a military level machine gun with a few rounds of ammo left", 15, 2));
        room1.addItemRoom(new MeleeWeapon("sword", "A long sword with a golden handle", 20));

        //ROOM2-------------
        room2.setEastConnection(room3);
        room2.setWestConnection(room1);
        room2.addItemRoom(new Food("potion", "A magical potion with a strange substance in it", -10));
        room2.addEnemyRoom(new Enemy("skeleton", "A gross looking skeleton holding a pistol", 50, new RangedWeapon("pistol", "An old pistol", 7, 12)));

        //ROOM3-------------
        room3.setWestConnection(room2);
        room3.setSouthConnection(room6);
        room3.addItemRoom(new MeleeWeapon("knife", "A dull knife with a rusty blade", 10));

        //ROOM4--------------
        room4.setNorthConnection(room1);
        room4.setSouthConnection(room7);
        room4.addItemRoom(new Item("book", "A book with magical spells in it"));

        //ROOM5--------------
        room5.setSouthConnection(room8);
        room5.addEnemyRoom(new Enemy("ghost bear", "a ghost bear with no eyes is approaching", 50, new MeleeWeapon("claws", "Claws that scratch", 50)));

        //ROOM6--------------
        room6.setNorthConnection(room3);
        room6.setSouthConnection(room9);
        room6.addItemRoom(new Item ("skull", "A skull with golden teeth"));
        room6.addItemRoom(apple);

        //ROOM7--------------
        room7.setNorthConnection(room4);
        room7.setEastConnection(room8);

        //ROOM8--------------
        room8.setNorthConnection(room5);
        room8.setEastConnection(room9);
        room8.setWestConnection(room7);
        room8.addItemRoom(apple);

        //ROOM9--------------
        room9.setNorthConnection(room6);
        room9.setWestConnection(room8);
        room9.addItemRoom(new Item ("key", "A golden key"));

    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public Room getStarterRoom() {
        return starterRoom;
    }

    //------------------------------------------------------------------------------------------------------------------
}
