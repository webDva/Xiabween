package backend;

import com.badlogic.gdx.math.Vector2;

import entities.PlayerCharacter;

public class PlayerHandler {

	public static void movePlayer(PlayerCharacter player, String direction, Vector2 coordinates) {
		player.direction = direction;
		player.position.x += coordinates.x;
		player.position.y += coordinates.y;
	}

	public static void changeHealth(PlayerCharacter player, float health_displacement) {

		player.health += health_displacement;
	}

	public static PlayerCharacter createPlayer(String name, Vector2 coordinates, float health) {

		PlayerCharacter newplayer = new PlayerCharacter();

		newplayer.name = name;
		newplayer.position = new Vector2(coordinates);
		newplayer.health = health;

		// Don't load the texture here, but instead, load it in a Screen class.

		newplayer.direction = PlayerCharacter.DOWN; // Default direction that the player is facing upon creation.

		return newplayer;
	}

}
