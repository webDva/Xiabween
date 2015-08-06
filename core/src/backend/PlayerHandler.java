package backend;

public class PlayerHandler {

	public static void movePlayer(PlayerCharacter player, int x, int y) { // Note that the player should only move left
																			// or right and maybe jump.
		player.x = x;
		player.y = y;
	}

	public static void changeHealth(PlayerCharacter player, float health) {
		player.health = health;
	}

	public static PlayerCharacter createPlayer(String name, int x, int y, float health, XBLogician logician) { // Initializing
																												// a new
																												// player
		// object.
		PlayerCharacter newplayer = new PlayerCharacter();
		newplayer.name = name;
		newplayer.x = x;
		newplayer.y = y;
		newplayer.health = health;

		logician.players.add(newplayer);

		return newplayer;
	}

}
