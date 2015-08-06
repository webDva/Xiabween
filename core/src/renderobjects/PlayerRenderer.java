package renderobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class PlayerRenderer {

	public String charactername;
	public Texture playertexture;
	public int x, y;

	public Rectangle playersize; // For collision detection here instead of in the game logician.--Or maybe not.

	public PlayerRenderer(String name, String path, int x, int y) {
		this.charactername = name;

		this.playersize = new Rectangle();

		this.x = x;
		this.y = y;

		// this.playersize.height = height;
		// this.playersize.width = width;
		// this.playersize.x = x;
		// this.playersize.y = y;

		this.playertexture = new Texture(path);
	}

}
