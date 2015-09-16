package entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * A XiaEntity struct for rendering a PlayerLogic object.
 *
 * @author sorcerer
 *
 */
public class PlayerEntity extends XiaEntity {

	public static final String UP = "north", RIGHT = "east", DOWN = "south", LEFT = "west";

	public String direction;
	public boolean isAnimating;
	public PlayerTextures textures; // Contains idle and walking animation frames.
	public String name;
	public Rectangle playerRectangle;

	public PlayerEntity(String name, Vector2 coordinates) {
		this.name = name;
		this.position = coordinates;

		/* Don't load textures here. */
		this.textures = null;
		this.playerRectangle = null;

		this.direction = DOWN; // default direction
		this.isAnimating = false;
	}

}
