package backend;

import com.badlogic.gdx.math.Vector2;

import entities.PlayerCharacter;

public class PlayerHandler {

	public static void movePlayer(PlayerCharacter player, Vector2 coordinates) {
		float x_delta, y_delta; // Should really learn about variable naming conventions. Felt the underscore one here
								// was necessary, because of their type and the x.
		x_delta = player.position.x - coordinates.x;
		y_delta = player.position.y - coordinates.y;

		if (x_delta > 0) {
			player.direction = "faces/left";
		} else if (x_delta < 0) {
			player.direction = "faces/right";
		}

		if (y_delta > 0) {
			player.direction = "faces/down";
		} else if (y_delta < 0) {
			player.direction = "faces/up";
		}

		player.position = coordinates;
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

		newplayer.direction = "faces/down"; // Default direction that the player is facing upon creation.

		return newplayer;
	}

}
