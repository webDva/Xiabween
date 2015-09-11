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
	private String playerName;
	/**
	 * Contains a reference to the sprite sheet that this character uses. This
	 * may blur the line between rendering and game logic, but at least no
	 * actual texture binding occurs. The value does not include the file
	 * extension, but only a name that references the character sprite sheet.
	 *
	 */
	private String associatedTexture;
	private MobType mobType;

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

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getAssociatedTexture() {
		return associatedTexture;
	}

	public void setAssociatedTexture(String associatedTexture) {
		this.associatedTexture = associatedTexture;
	}

	public MobType getMobType() {
		return mobType;
	}

	public void setMobType(MobType mobType) {
		this.mobType = mobType;
	}

}
