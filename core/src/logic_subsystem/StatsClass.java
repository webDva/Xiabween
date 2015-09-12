package logic_subsystem;

public abstract class StatsClass {

	/**
	 * Measured in meters per second. One meter should be the length of a tile
	 * or 32 pixels, but the logic side of Xiabween shouldn't concern itself
	 * with rendering and pixels for decouplization.
	 */
	public float movementSpeed;

}
