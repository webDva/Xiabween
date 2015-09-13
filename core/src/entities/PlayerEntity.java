package entities;

import com.badlogic.gdx.math.Rectangle;

/**
 * A Xia struct for rendering a PlayerLogic object.
 *
 * @author sorcerer
 *
 */
public class PlayerEntity extends XiaEntity {

	public static final String UP = "north", RIGHT = "east", DOWN = "south", LEFT = "west";

	public String direction; // Should make this an enumeration with radians.
								// Actually, the radians would be better suited for the game logic form of the player class.
	public boolean isAnimating;
	public PlayerTextures textures; // Contains idle and walking animation frames.
	public String name;
	public Rectangle playerRectangle;

}
