package renderobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class PlayerRenderer {

	public String charactername;
	public String texturepath;

	public Texture playertexture;

	public Rectangle playersize; // For collision detection here instead of in the game logician.

	public int xcoord, ycoord;

	public PlayerRenderer(String name, String path, int height, int width) {
		this.charactername = name;
		this.texturepath = path;

		this.playersize = new Rectangle();

		this.playersize.height = height;
		this.playersize.width = width;
		// What about the Rectangle's x and y?

		this.playertexture = new Texture(path);
	}

}
