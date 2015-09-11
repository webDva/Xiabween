package logic_subsystem;

/**
 * This is more than just for players, but for mobs and other NPCs as well.
 *
 * @author sorcerer
 *
 */
public abstract class ActualPlayerClass {

	private float x, y;
	/**
	 * Direction in radians the APC is facing. Radians are used because they
	 * have a standard of starting at the right of a unit circle and work best
	 * in terms of PI.
	 */
	private float radians_Direction;
	/**
	 * Measured in meters per second. One meter should be the length of a tile
	 * or 32 pixels, but the logic side of Xiabween shouldn't concern itself
	 * with rendering and pixels for decouplization.
	 *
	 */
	private float movementSpeed;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getRadians_Direction() {
		return radians_Direction;
	}

	public void setRadians_Direction(float radians_Direction) {
		this.radians_Direction = radians_Direction;
	}

	/**
	 * Changes the direction the {@link ActualPlayerClass} is facing. Add or
	 * subtract in terms of PI (<code>0PI, PI / 2, PI, 3PI / 2, 2PI</code>).
	 *
	 * @param displacement
	 *            The displacement in terms of PI.
	 */
	public abstract void changeDirection(float displacement);

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

}
