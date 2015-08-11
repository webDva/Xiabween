package backend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

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
			player.y += 1;
			break;
		case Keys.A:
			player.x -= 1;
			break;
		case Keys.S:
			player.y -= 1;
			break;
		case Keys.D:
			player.x += 1;
			break;
		case 0:
			// What to do here?
		}
	}
}
