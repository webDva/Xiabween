package xidecsc;

import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;
import player.ActualPlayerClass;

/**
 * Contains and modifies the state of game logic objects, such as if an object
 * even exists at all or its position. A {@link XIDECSCComponent}.
 *
 * @author sorcerer
 *
 */
public class StateContainer {

	public void movePlayer(ActualPlayerClass player, PlayerEntity entity, float angle, Vector2 displacement) {
		player.radians_Direction = angle;

		/*
		 * Check for collision elsewhere, by the way, not here in this method.
		 */

	}

}
