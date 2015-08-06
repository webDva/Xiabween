package backend;

import com.badlogic.gdx.graphics.Texture;

public class PlayerCharacter {

	public int x, y; // These aren't for rendering or collision detection, but are for instead actual gameplay mechanics
						// and logic.
	public String name;
	public float health;

	public Texture texture;

	// Let a PlayerCharacterHandler handle the player's initial x, y position and even health.

}
