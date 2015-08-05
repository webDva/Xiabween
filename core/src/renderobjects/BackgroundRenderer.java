package renderobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class BackgroundRenderer {

	public String backgroundname;
	public Rectangle backgroundsize;

	public String texturepath;
	public Texture texture;

	public BackgroundRenderer(String name, String imagetoload) {
		this.backgroundname = name;
		this.texturepath = imagetoload;
		this.texture = new Texture(imagetoload);

		this.backgroundsize = new Rectangle();

		this.backgroundsize.x = 0;
		this.backgroundsize.y = 0;
	}
}
