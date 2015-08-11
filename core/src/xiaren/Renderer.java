package xiaren;

import java.util.List;

import backend.Fireball;
import backend.PlayerCharacter;
import backend.Logician;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Renderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;

	public Texture background;

	public Renderer(boolean createOwnRenders) {
		if (createOwnRenders) {
			this.batch = new SpriteBatch();
			this.camera = new OrthographicCamera();
		}

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

	public void renderBackground(int x, int y, OrthographicCamera camera, SpriteBatch spritebatch) {
		spritebatch.setProjectionMatrix(camera.combined);
		spritebatch.begin();

		spritebatch.draw(this.background, x, y);

		spritebatch.end();
	}

	public void SetCamera(OrthographicCamera camera, int width, int height) {
		camera.setToOrtho(false, width, height);
	}

	public void renderFireblast(Fireball fireball, int x, int y) {

	}

	public void renderStates(Logician logicdata) { // Will act as a main rendering loop.
		for (PlayerCharacter player : logicdata.players) {
			this.renderPlayer(batch, player);
		}

		// TODO Use an abstract game object that can be generic for all types of game objects such as player entities,
		// skill
		// effects, mob entities, and environmental entities.

		for (Fireball fireball : logicdata.fireballs) {
			this.renderFireblast(fireball, fireball.x, fireball.y);
		}
	}

}
