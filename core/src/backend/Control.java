package backend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import entities.PlayerCharacter;

public class Control { // Handles input from the player user. This goes into processStates since it deals with game

	// logic.

	public static int checkIfMovementKeyIsPressed() {
		if (Gdx.input.isKeyPressed(Keys.W)) {
			return Keys.W;

		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			return Keys.A;

		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			return Keys.S;

		} else if (Gdx.input.isKeyPressed(Keys.D)) {
			return Keys.D;

		} else {
			return 0; // TODO Might be screwed here, what with the issue of user validation and all.
		}
	}

	public static void doIfKeyIsPressed(int keycode, PlayerCharacter player) {
		switch (keycode) {
		case Keys.W:
			PlayerHandler.movePlayer(player, player.x, player.y + 1);
			break;
		case Keys.A:
			PlayerHandler.movePlayer(player, player.x - 1, player.y);
			break;
		case Keys.S:
			PlayerHandler.movePlayer(player, player.x, player.y - 1);
			break;
		case Keys.D:
			PlayerHandler.movePlayer(player, player.x + 1, player.y);
			break;
		case 0:
			// What to do here?
		}
	}
}
