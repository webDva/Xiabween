package backend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;

public class Control {

	public static final Vector2 MOVE_UP = new Vector2(-1, 1);

	public static void checkIfMovementKeyIsPressed(PlayerEntity player) {
		if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.A)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.LEFT, new Vector2(-1, 1));
		} else if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.RIGHT, new Vector2(1, 1));
		}

		else if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.LEFT, new Vector2(-1, -1));
		} else if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.D)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.RIGHT, new Vector2(1, -1));
		}

		else if (Gdx.input.isKeyPressed(Keys.W)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.UP, new Vector2(0, 1));
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.LEFT, new Vector2(-1, 0));
		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.DOWN, new Vector2(0, -1));
		} else if (Gdx.input.isKeyPressed(Keys.D)) {
			PlayerEntityHandler.movePlayer(player, PlayerEntity.RIGHT, new Vector2(1, 0));
		}
	}
}
