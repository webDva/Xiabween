// Forget about what to render right now, and just start rendering.

package xiaren;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class XiaRen {

	public void renderPlayer(PlayerRender playerobject, SpriteBatch spritebatch, int xpos, int ypos) {
		spritebatch.begin();

		playerobject.xcoord = xpos;
		playerobject.ycoord = ypos;
		spritebatch.draw(playerobject.playertexture, playerobject.xcoord, playerobject.ycoord);

		spritebatch.end();
	}

	public void renderBackground(OrthographicCamera camera, BackgroundRender background, SpriteBatch spritebatch) {
		spritebatch.setProjectionMatrix(camera.combined);
		spritebatch.begin();

		spritebatch.draw(background.texture, background.backgroundsize.x, background.backgroundsize.y);

		spritebatch.end();
	}

	public void SetCamera(OrthographicCamera camera, int windowwidth, int windowheight) {
		camera.setToOrtho(false, windowwidth, windowheight);
	}

}
