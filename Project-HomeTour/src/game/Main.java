package game;

import java.util.Scanner;
import fixtures.Room;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static RoomManager roomManager = new RoomManager(10);
	public static Player player = new Player();
	public static boolean playing = true;
	public static Room currentRoom;
	public static String[] command;
	public static String direction;
	public static String action;

	public static void main(String[] args) {
		roomManager.init();
		player.setCurrentRoom(roomManager.getStartingRoom());

		System.out.println("Welcome to my house tour!" + "\n"
				+ "You enter the house through the front door directly into a foyer.");

		printRoom(player);

		// keeps the command line going until the player quits
		while (playing) {

			collectInput();
			parse(command, player);
			if (action != null) {
				switch (action) {
				case "quit": {
					System.out.println("Thank you for touring my house!");
					playing = false;
					break;
				}
				case "go": {
					switch (direction) {
					case "west": {
						player.setCurrentRoom(player.getCurrentRoom().getExit(currentRoom, "west"));
						printRoom(player);
						break;
					}
					case "north": {
						player.setCurrentRoom(player.getCurrentRoom().getExit(currentRoom, "north"));
						printRoom(player);
						break;
					}
					case "east": {
						player.setCurrentRoom(player.getCurrentRoom().getExit(currentRoom, "east"));
						printRoom(player);
						break;
					}
					case "south": {
						player.setCurrentRoom(player.getCurrentRoom().getExit(currentRoom, "south"));
						printRoom(player);
						break;
					}
					default: {
						System.out.println("Did not receive a direction.");
						break;
					}
					}
					break;
				}
				default: {
					System.out.println("Please enter a direction or quit.");
					break;
				}
				}
			} else {
				continue;
			}
		}
	}

	private static void printRoom(Player player) {
		System.out.println("\n" + "You've entered the " + player.getCurrentRoom().getName() + ".");
		System.out.println(player.getCurrentRoom().getLongDescription());
	}

	private static String[] collectInput() {
		command = scanner.nextLine().split(" ");
		return command;
	}

	private static void parse(String[] command, Player player) {
		for (int i = 0; i < command.length; i++) {
			if (command[i].equalsIgnoreCase("quit")) {
				action = "quit";
			} else if (command[i].equalsIgnoreCase("west")) {
				if (player.getCurrentRoom().getExit(currentRoom, "west") != null) {
					action = "go";
					direction = "west";
					break;
				} else {
					action = "incorrect";
					System.out.println("You can't go this way. Please enter another direction.");
				}
			} else if (command[i].equalsIgnoreCase("north")) {
				if (player.getCurrentRoom().getExit(currentRoom, "north") != null) {
					action = "go";
					direction = "north";
					break;
				} else {
					action = "incorrect";
					System.out.println("You can't go this way. Please enter another direction.");
				}
			} else if (command[i].equalsIgnoreCase("east")) {
				if (player.getCurrentRoom().getExit(currentRoom, "east") != null) {
					action = "go";
					direction = "east";
					break;
				} else {
					action = "incorrect";
					System.out.println("You can't go this way. Please enter another direction.");
				}
			} else if (command[i].equalsIgnoreCase("south")) {
				if (player.getCurrentRoom().getExit(currentRoom, "south") != null) {
					action = "go";
					direction = "south";
					break;
				} else {
					action = "incorrect";
					System.out.println("You can't go this way. Please enter another direction.");
				}
			} else if (!command[i].equalsIgnoreCase("go")){
				action = "incorrect";
				System.out.println("Please try again!");
			}
		}
	}
}