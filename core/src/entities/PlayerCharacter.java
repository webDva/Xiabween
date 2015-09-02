package entities;

public class PlayerCharacter extends RenderObject {

	public static final String UP = "north", RIGHT = "east", DOWN = "south", LEFT = "west";

	public String direction; // Should make this an enumeration with radians.
	public boolean isAnimating;
	public PlayerTextures textures; // Contains idle and walking animation frames.
	public String name;

}
