package backend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import entities.PlayerCharacter;

public class Control { // Handles input from the player user. This goes into processStates since it deals with game

	// logic.

	public static void checkIfMovementKeyIsPressed(PlayerCharacter player) {
		if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.A)) {
			PlayerHandler.movePlayer(player, new Vector2(-1, 1));
		}
		if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)) {
			PlayerHandler.movePlayer(player, new Vector2(1, 1));
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			PlayerHandler.movePlayer(player, new Vector2(0, 1));
		}

		if (Gdx.input.isKeyPressed(Keys.A)) {
			PlayerHandler.movePlayer(player, new Vector2(-1, 0));

		}
		if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)) {
			PlayerHandler.movePlayer(player, new Vector2(-1, -1));
		}
		if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.D)) {
			PlayerHandler.movePlayer(player, new Vector2(1, -1));
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			PlayerHandler.movePlayer(player, new Vector2(0, -1));
		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			PlayerHandler.movePlayer(player, new Vector2(1, 0));
		}
	}
}
