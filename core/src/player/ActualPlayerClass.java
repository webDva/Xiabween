package player;

/**
 * This is more than just for players, but for mobs and other NPCs as well.
 *
 * @author sorcerer
 *
 */
public abstract class ActualPlayerClass {

	public float x, y;
	/**
	 * Direction in radians the {@link ActualPlayerClass} is facing. Radians are
	 * used because they have a standard of starting at the right of a unit
	 * circle and work best in terms of PI.
	 *
	 * To change the direction if the {@link ActualPlayerClass} is actually
	 * turning, add or subtract the displacement in terms of PI (
	 * <code>0PI, PI / 2, PI, 3PI / 2, 2PI</code>).
	 */
	public double radians_Direction;
	public String playerName;
	/**
	 * Contains a reference to the sprite sheet that this character uses. This
	 * may blur the line between rendering and game logic, but at least no
	 * actual texture binding occurs. Now contains the file path, at least the
	 * extension.
	 */
	public String texturePath;
	public MobType mobType;
	public float speed;

}
