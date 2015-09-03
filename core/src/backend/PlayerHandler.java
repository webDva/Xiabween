package backend;

import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;

public class PlayerHandler {

	public static void movePlayer(PlayerEntity player, String direction, Vector2 coordinates) {
		player.direction = direction;
		player.position.x += coordinates.x;
		player.position.y += coordinates.y;

		player.isAnimating = true;
	}

	public static PlayerEntity createPlayer(String name, Vector2 coordinates) {

		PlayerEntity newplayer = new PlayerEntity();

		newplayer.position = new Vector2(coordinates);

		// Don't load the texture here, but instead, load it in a Screen class.

		newplayer.direction = PlayerEntity.DOWN; // Default direction that the player is facing upon creation.
		newplayer.isAnimating = false;

		newplayer.name = name;

		return newplayer;
	}

}
