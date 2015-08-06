// Forget about what to render right now, and just start rendering.

package xiaren;

import java.util.ArrayList;
import java.util.List;

import renderobjects.BackgroundRenderer;
import renderobjects.FireballRenderer;
import renderobjects.PlayerRenderer;

import backend.PlayerCharacter;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class XBRenderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;

	// List of objects that can be rendered.
	public List<PlayerRenderer> render_playerlist;
	public List<FireballRenderer> fireballlist;

	public XBRenderer(boolean createOwnRenders) {
		if (createOwnRenders) {
			this.batch = new SpriteBatch();
			this.camera = new OrthographicCamera();
		}

		render_playerlist = new ArrayList<PlayerRenderer>();
		fireballlist = new ArrayList<FireballRenderer>();
	}

	public PlayerRenderer createPlayerRendererObject(PlayerCharacter playerinfo) {
		String texturepath = playerinfo.name + ".png";
		PlayerRenderer newrenderer = new PlayerRenderer(playerinfo.name, texturepath, playerinfo.x, playerinfo.x);

		this.render_playerlist.add(newrenderer); // Be so kind as to update that array as well, since you created this
													// PlayerRenderer yourself.

		return newrenderer;
	}

	public void renderPlayer(PlayerRenderer playerobject, SpriteBatch spritebatch, int xpos, int ypos) {
		spritebatch.begin();

		playerobject.x = xpos;
		playerobject.y = ypos;
		spritebatch.draw(playerobject.playertexture, playerobject.x, playerobject.y);

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

	public void renderFireblast(FireballRenderer fireball, int x, int y) {

	}

}
