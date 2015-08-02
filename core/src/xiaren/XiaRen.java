// Forget about what to render right now, and just start rendering.

package xiaren;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class XiaRen extends ApplicationAdapter {
	public static final int windowwidth = 1024;
	public static final int windowheight = 768;

	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("64x64shana.png");
	}

	@Override
	public void render () {
		// First, render the background, then center camera on the player's character.
		// So that means to create a player object and a camera object as well as a
		// background object. Or class.

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, windowheight / 2, windowwidth / 2);
		batch.end();
	}
}
