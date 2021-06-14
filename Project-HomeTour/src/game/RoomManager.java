package game;

import fixtures.Room;

/*
 * This class will be responsible for "loading" our rooms into memory.
 * When game.Main is executed, it will invoke the init() method in this
 * class that will instantiate all our Room objects, link them together as exits, 
 * and designate a startingRoom.
 * 		- Room startingRoom: the room a player should start in
 * 		- Room[] rooms: all the rooms in the house.
 * */

public class RoomManager {

	Room startingRoom;
	Room[] rooms;

	// Getter & Setter methods for Starting Room
	public Room getStartingRoom() {
		return startingRoom;
	}

	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}

	// Getter & Setter methods for rooms (all of them)
	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	// This decides the number of rooms for the RoomManager
	public RoomManager(int index) {
		this.rooms = new Room[index];
	}

	public void init() {
		Room foyer = new Room("foyer", "A small foyer",
				"\nOn the wall left of the front door, there is a hanging coat rack. \n\n*** A dining room is open to the south, where a wooden table can be seen."
						+ "\n*** The hardwood floor leads west into a small space with a small decorative bench, \nnext to a staircase that leads up to a second floor."
						+ "\n*** To the north is a small room, where you can see a piano.");
		rooms[0] = foyer;
		setStartingRoom(foyer);

		Room den = new Room("den", "The warmly lit den",
				"\nYou enter a warmly lit den. The walls are lined with bookcases that touch the ceiling, \nfilled with books of all sizes and colors."
						+ "\nA large woven rug with red floral motifs covers the center of the room. In one corner, there is a classic piano."
						+ "\n\n*** To the west is the family room." + "\n*** To the south is the foyer.");
		rooms[1] = den;

		Room familyRoom = new Room("family room", "A Spacious Family Room", "\nThis room is spacious and relaxing."
				+ "The north and west facing walls each have two large windows. \nUnderneath the windows are many potted house plants."
				+ "\n\n*** To the east is the den."
				+ "\n*** A kitchen is open to the south, where white cabinets and wall tile backsplash can be seen.");
		rooms[2] = familyRoom;

		Room kitchen = new Room("kitchen", "A modern kitchen",
				"\nThe kitchen is bright and airy, the cabinets painted white.\nIt looks like the kitchen has been remodeled recently."
						+ "\n\n*** To the north is the family room." + "\n*** To the east is the dining room."
						+ "\n*** To the south is the laundry room.");
		rooms[3] = kitchen;

		Room diningRoom = new Room("dining room", "An elegant dining room",
				"\nIn the center of the dining room there is a humble dining table with 6 wooden chairs. "
						+ "\nA modern light fixture floats above the table and casts a nice glow."
						+ "\n\n*** To the west is the kitchen" + "\n*** To the north is the foyer.");
		rooms[4] = diningRoom;

		Room laundryRoom = new Room("laundry room", "A clean laundry room", "" + "\n*** To the north is the kitchen.");
		rooms[5] = laundryRoom;

		Room staircase = new Room("staircase", "The Wooden Staircase",
				"" + "\n*** To the west is the second story hallway." + "\n*** To the east is the foyer.");
		rooms[6] = staircase;

		Room hallway = new Room("hallway", "The carpeted hallway",
				"\nThe walls have decorative frames with pictures of a young couple and their dog."
						+ "\n\n*** To the west is a small bedroom, it's door is open."
						+ "\n*** To the north is the master bedroom, it's door is also open."
						+ "\n*** To the east is the staircase.");
		rooms[7] = hallway;

		Room smallBedroom = new Room("small bedroom", "A small bedroom",
				"\nThis small bedroom has a full-sized bed with decorative pillows and a knitted comforter."
						+ "\n\n*** To the east is the hallway.");
		rooms[8] = smallBedroom;

		Room masterBedroom = new Room("master bedroom", "A large master bedroom",
				"\nThe spacious master bedroom is lined with north facing windows."
						+ "\n\n*** To the south is the hallway.");
		rooms[9] = masterBedroom;

		// -------------
		// Exit Arrays
		//
		// Room[] roomExits = {west, north, east, south};
		// room.setExits(roomExits);
		// -------------

		// foyer exits
		Room[] foyerExits = { staircase, den, null, diningRoom };
		foyer.setExits(foyerExits);

		// den exits
		Room[] denExits = { familyRoom, null, null, foyer };
		den.setExits(denExits);

		// family room exits
		Room[] familyRoomExits = { null, null, den, kitchen };
		familyRoom.setExits(familyRoomExits);

		// kitchen exits
		Room[] kitchenExits = { null, familyRoom, diningRoom, laundryRoom };
		kitchen.setExits(kitchenExits);

		// dining room exits
		Room[] diningRoomExits = { kitchen, foyer, null, null };
		diningRoom.setExits(diningRoomExits);

		// laundry room exits
		Room[] laundryRoomExits = { null, kitchen, null, null };
		laundryRoom.setExits(laundryRoomExits);

		// staircase exits
		Room[] staircaseExits = { hallway, null, foyer, null };
		staircase.setExits(staircaseExits);

		// hallway exits
		Room[] hallwayExits = { smallBedroom, masterBedroom, staircase, null };
		hallway.setExits(hallwayExits);

		// small bedroom exits
		Room[] smallBedroomExits = { null, null, hallway, null };
		smallBedroom.setExits(smallBedroomExits);

		// master bedroom exits
		Room[] masterBedroomExits = { null, null, null, hallway };
		masterBedroom.setExits(masterBedroomExits);
	}
}