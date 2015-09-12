package logic_subsystem;

/**
 * This is more than just for players, but for mobs and other NPCs as well.
 *
 * @author sorcerer
 *
 */
public class ActualPlayerClass {

	public float x, y;
	/**
	 * Direction in radians the APC is facing. Radians are used because they
	 * have a standard of starting at the right of a unit circle and work best
	 * in terms of PI.
	 *
	 * To change the direction the {@link ActualPlayerClass} is facing, add or
	 * subtract the displacement in terms of PI (
	 * <code>0PI, PI / 2, PI, 3PI / 2, 2PI</code>).
	 */
	public float radians_Direction;
	public String playerName;
	/**
	 * Contains a reference to the sprite sheet that this character uses. This
	 * may blur the line between rendering and game logic, but at least no
	 * actual texture binding occurs. The value does not include the file
	 * extension, but only a name that references the character sprite sheet.
	 */
	public String associatedTexture;
	public final MobType mobType;
	public StatsClass stats;

	public ActualPlayerClass(MobType type) {
		this.mobType = type;
	}

}
