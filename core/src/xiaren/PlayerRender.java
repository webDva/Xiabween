package xiaren;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class PlayerRender {
	public String charactername;
	public String texturepath;

	public Texture playertexture;

	public Rectangle playersize;

	public int xcoord, ycoord;

	public PlayerRender(String name, String path, int height, int width) {
		this.charactername = name;
		this.texturepath = path;

		this.playersize = new Rectangle();

		this.playersize.height = height;
		this.playersize.width = width;
		// What about the Rectangle's x and y?

		this.playertexture = new Texture(path);
	}

}
