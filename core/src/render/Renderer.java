package render;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import backend.Logician;
import entities.Fireball;
import entities.PlayerCharacter;

public class Renderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;
	public int camera_width = 480, camera_height = 480; // These won't be final, because there may be a time when a screen object would want to change these.

	public Texture background;

	public Renderer(boolean createOwnRenders) {
		if (createOwnRenders) {
			this.batch = new SpriteBatch();
			this.camera = new OrthographicCamera();
		}

		camera.setToOrtho(false, this.camera_width, this.camera_height);

		// TODO Should really put all rendering into here (such as loading textures/textureatlases/textureregions)
		// instead of the Screen class.

		// Load initial things using a load method.
	}

	// Can be used for each new screen created, so make the arguments a list of things to load, such as:
	// TextureAtlases to load, TextureRegions to load, regular Textures to load, and even Sprites.
	public void loadThings(List<TextureAtlas> texture_atlases, List<TextureRegion> texture_regions,
			List<Texture> textures) {

	}

	public void loadBackground(String path) {
		this.background = new Texture(path);
	}

	public void renderPlayer(SpriteBatch spritebatch, PlayerCharacter playerinfo) {
		spritebatch.begin();

		spritebatch.draw(playerinfo.texture, playerinfo.x, playerinfo.y);

		spritebatch.end();
	}

	public void renderBackground(int x, int y, SpriteBatch spritebatch) {
		spritebatch.setProjectionMatrix(this.camera.combined);
		spritebatch.begin();

		spritebatch.draw(this.background, x, y);

		spritebatch.end();
	}

	public void renderFireblast(Fireball fireball, int x, int y) {

	}

	public void renderStates(Logician logicdata) { // Will act as a main rendering loop.
		for (PlayerCharacter player : logicdata.players) {
			this.renderPlayer(batch, player);
		}

		this.camera.position.set(logicdata.players.get(0).x, logicdata.players.get(0).y, 0);
		this.camera.update();

		// TODO Use an abstract game object that can be generic for all types of game objects such as player entities,
		// skill effects, mob entities, and environmental entities.

		for (Fireball fireball : logicdata.fireballs) {
			this.renderFireblast(fireball, fireball.x, fireball.y);
		}
	}

}
