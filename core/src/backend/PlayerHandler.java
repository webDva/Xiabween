package backend;

import com.badlogic.gdx.math.Vector2;

import entities.PlayerCharacter;

public class PlayerHandler {

	public static void movePlayer(PlayerCharacter player, float x, float y) {
		player.position.x = x;
		player.position.y = y;
	}

	public static void changeHealth(PlayerCharacter player, float health) {

		player.health = health;
	}

	public static PlayerCharacter createPlayer(String name, Vector2 coordinates, float health) {

		PlayerCharacter newplayer = new PlayerCharacter();

		newplayer.name = name;
		newplayer.position = new Vector2(coordinates);
		newplayer.health = health;

		// Don't load the texture here, but instead, load it in a Screen class.

		return newplayer;
	}

}
