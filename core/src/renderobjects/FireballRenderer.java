package renderobjects;

import com.badlogic.gdx.graphics.Texture;

public class FireballRenderer {

	// Just need the coordinates and texture to render a fireball.
	public int x, y;
	public Texture fireballtexture; // TODO Add texture for a fireball.

	public FireballRenderer(int x, int y, String texturepath) {
		this.x = x;
		this.y = y;
		this.fireballtexture = new Texture(texturepath);
	}

}
