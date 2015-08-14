package render;

import java.util.List;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import backend.Logician;
import entities.Fireball;
import entities.PlayerCharacter;

public class Renderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;
	public int camera_width = 1024, camera_height = 700; // These won't be final, because there may be a time when a screen object would want to change these.

	public Texture background;

	public TiledMap tiledmap;
	public OrthogonalTiledMapRenderer tile_renderer;
	public float unitscale = 1 / 32f;

	public Renderer(boolean createOwnRenders) {
		if (createOwnRenders) {
			this.batch = new SpriteBatch();
			this.camera = new OrthographicCamera();
		}
		
		batch.setProjectionMatrix(camera.combined);

		this.tiledmap = new TmxMapLoader().load("grass.tmx");
		this.tile_renderer = new OrthogonalTiledMapRenderer(tiledmap);

		camera.setToOrtho(false, 400, 400);
		

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

	public void renderPlayer(Batch batch, PlayerCharacter playerinfo) {
		batch.begin();

		batch.draw(playerinfo.texture, playerinfo.x, playerinfo.y);

		batch.end();
	}



	public void renderFireblast(Fireball fireball, int x, int y) {

	}

	public void renderStates(Logician logicdata) { // Will act as a main rendering loop.
		tile_renderer.setView(camera);
		tile_renderer.render();

		for (PlayerCharacter player : logicdata.players) {
			this.renderPlayer(tile_renderer.getBatch(), player);
		}

		camera.position.set(logicdata.players.get(0).x + 50, logicdata.players.get(0).y + 50, 0); // I know that the character is 100 pixels high and wide.
		camera.update();

		// TODO Use an abstract game object that can be generic for all types of game objects such as player entities,
		// skill effects, mob entities, and environmental entities.

		for (Fireball fireball : logicdata.fireballs) {
			this.renderFireblast(fireball, fireball.x, fireball.y);
		}
	}

}
