package render;

import com.badlogic.gdx.math.Vector2;

/**
 * Handles collision detection.
 * 
 * @author sorcerer
 * 
 */
public class CollisionDetector {

	/**
	 * Determines if two objects will collide. The first is usually a moving
	 * object while the second is stationary, like a tile.
	 * 
	 * TODO: Use only a collision layer to not iterate over a lot of stuff.
	 * 
	 * @param firstObjectCoordinates
	 *            The moving object.
	 * @param secondObjectCoordinates
	 *            The stationary object.
	 * @return true if the two objects will collide with each other.
	 */
	public static boolean willCollide(Vector2 firstObjectCoordinates, Vector2 secondObjectCoordinates) {
		return false;
	}

}
