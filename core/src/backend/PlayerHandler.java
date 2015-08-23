package backend;

import com.badlogic.gdx.math.Vector2;

import entities.PlayerCharacter;

public class PlayerHandler {

	public static void movePlayer(PlayerCharacter player, String direction, Vector2 coordinates) {
		player.direction = direction;
		player.position.x += coordinates.x;
		player.position.y += coordinates.y;

		player.isAnimating = true;
	}

	public static PlayerCharacter createPlayer(Vector2 coordinates) {

		PlayerCharacter newplayer = new PlayerCharacter();

		newplayer.position = new Vector2(coordinates);

		// Don't load the texture here, but instead, load it in a Screen class.

		newplayer.direction = PlayerCharacter.DOWN; // Default direction that the player is facing upon creation.
		newplayer.isAnimating = false;

		return newplayer;
	}

}
