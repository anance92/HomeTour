package game;

import fixtures.Room;

/*
 * Represents the player moving through each room. Has the following properties:
 * 				- Room currentRoom: the room the player is currently in.
 */

public class Player {
	Room currentRoom;
	
	// Getter & Setter methods for the current room
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
}