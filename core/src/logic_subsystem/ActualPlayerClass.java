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
	 * Direction in radians the APC is facing.
	 */
	private float radians_Direction;

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

}
