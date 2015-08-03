package xiaren;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class BackgroundRender {

	public String backgroundname;
	public Rectangle backgroundsize;

	public String texturepath;
	public Texture texture;

	public BackgroundRender(String name, String imagetoload) {
		this.backgroundname = name;
		this.texturepath = imagetoload;
		this.texture = new Texture(imagetoload);

		this.backgroundsize = new Rectangle();

		this.backgroundsize.x = 0;
		this.backgroundsize.y = 0;
	}
}
