package render;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;

/**
 * Handles collision detection.
 *
 * @author sorcerer
 *
 */
public class CollisionDetector {

	public static final int FEET_HEIGHT = 7;

	/**
	 * Determines if two objects will collide. The first is usually a moving
	 * object while the second is stationary, like a tile.
	 *
	 * TODO: Use only a collision layer to not iterate over a lot of stuff.
	 *
	 * @param player
	 *            Uses the bottom portion (feet area) of the
	 *            {@link PlayerEntity}'s rectangle.
	 * @param areaCoordinates
	 *            The spot the {@link PlayerEntity} wants to move to.
	 * @return true if the two objects will collide with each other.
	 */
	public static boolean willPlayerCollide(Rectangle player, Vector2 areaCoordinates) {

		return false;
	}
}
