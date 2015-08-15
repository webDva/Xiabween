package backend;

import entities.PlayerCharacter;

public class PlayerHandler {

	public static void movePlayer(PlayerCharacter player, int x, int y) {
		player.x = x;
		player.y = y;
	}

	public static void changeHealth(PlayerCharacter player, float health) {

		player.health = health;
	}

	public static PlayerCharacter createPlayer(String name, int x, int y, float health) {

		PlayerCharacter newplayer = new PlayerCharacter();

		newplayer.name = name;
		newplayer.x = x;
		newplayer.y = y;
		newplayer.health = health;

		// Don't load the texture here, but instead, load it in a Screen class.

		return newplayer;
	}

}
