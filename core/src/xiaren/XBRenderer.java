// Forget about what to render right now, and just start rendering.

package xiaren;

import renderobjects.BackgroundRenderer;
import renderobjects.PlayerRenderer;

import backend.Fireball;
import backend.PlayerCharacter;
import backend.XBLogician;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class XBRenderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;

	public XBRenderer(boolean createOwnRenders) {
		if (createOwnRenders) {
			this.batch = new SpriteBatch();
			this.camera = new OrthographicCamera();
		}

	}

	public PlayerRenderer createPlayerRendererObject(PlayerCharacter playerinfo) {
		String texturepath = playerinfo.name + ".png";
		PlayerRenderer newrenderer = new PlayerRenderer(playerinfo.name, texturepath, playerinfo.x, playerinfo.x);

		return newrenderer;
	}

	public void renderPlayer(SpriteBatch spritebatch, PlayerCharacter playerinfo) {
		spritebatch.begin();

		spritebatch.draw(playerinfo.texture, playerinfo.x, playerinfo.y);

		spritebatch.end();
	}

	public void renderBackground(OrthographicCamera camera, BackgroundRenderer background, SpriteBatch spritebatch) {
		spritebatch.setProjectionMatrix(camera.combined);
		spritebatch.begin();

		spritebatch.draw(background.texture, background.backgroundsize.x, background.backgroundsize.y);

		spritebatch.end();
	}

	public void SetCamera(OrthographicCamera camera, int windowwidth, int windowheight) {
		camera.setToOrtho(false, windowwidth, windowheight);
	}

	public void renderFireblast(Fireball fireball, int x, int y) {

	}

	public void renderStates(XBLogician logicdata) { // Will act as a main rendering loop.
		for (PlayerCharacter player : logicdata.players) {
			this.renderPlayer(batch, player);
		}
		for (Fireball fireball : logicdata.fireballs) {
			this.renderFireblast(fireball, fireball.x, fireball.y);
		}
	}

}
