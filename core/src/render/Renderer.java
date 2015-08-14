package render;

import java.util.List;

import backend.Logician;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import entities.Fireball;
import entities.Map_struct;
import entities.PlayerCharacter;

public class Renderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;
	public int camera_width = 1024, camera_height = 700; // These won't be final, because there may be a time when a screen object would want to change these.

	public Map_struct currentMap;

	public Renderer(boolean createOwnRenders, int cameraViewPortWidth, int cameraViewPortHeight) {
		if (createOwnRenders) {
			this.batch = new SpriteBatch();
			this.camera = new OrthographicCamera();
		}

		setCameraViewPorts(cameraViewPortWidth, cameraViewPortHeight);

		//this.tiledmap = new TmxMapLoader().load("grass.tmx");
		//this.tile_renderer = new OrthogonalTiledMapRenderer(tiledmap);

		// TODO Should really put all rendering into here (such as loading textures/textureatlases/textureregions)
		// instead of the Screen class.

		// Load initial things using a load method.
	}

	// Can be used for each new screen created, so make the arguments a list of things to load, such as:
	// TextureAtlases to load, TextureRegions to load, regular Textures to load, and even Sprites.
	public void loadThings(List<TextureAtlas> texture_atlases, List<TextureRegion> texture_regions,
			List<Texture> textures) {

	}

	public void loadMaps(List<Map_struct> mapStructs) {
		// Load all the tiled maps that belong to the Screen class caller that it has supplied to the Renderer.
		for (Map_struct struct : mapStructs) {
			struct.map = new TmxMapLoader().load(struct.path);
			struct.mapRenderer = new OrthogonalTiledMapRenderer(struct.map);
		}
	}

	public void renderPlayer(Batch batch, PlayerCharacter playerinfo) {
		batch.begin();

		batch.draw(playerinfo.texture, playerinfo.x, playerinfo.y);

		batch.end();
	}

	public void renderFireblast(Fireball fireball, int x, int y) {

	}

	public void setCameraViewPorts(int viewWidth, int viewHeight) {
		this.camera.setToOrtho(false, viewWidth, viewHeight);
	}

	public void setCurrentMap(Map_struct map) {
		this.currentMap = map;
	}

	// TODO: Have a way to tell a Renderer object from a caller to control a camera based on the requests of a caller.
	public void renderStates(Logician logicdata) { // Will act as a main rendering loop.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		currentMap.mapRenderer.setView(camera);
		currentMap.mapRenderer.render();

		for (PlayerCharacter player : logicdata.players) {
			renderPlayer(currentMap.mapRenderer.getBatch(), player);
		}

		camera.position.set(logicdata.players.get(0).x + 50, logicdata.players.get(0).y + 50, 0); // I know that the character is 100 pixels high and wide.
		camera.update();

		// TODO Use an abstract game object that can be generic for all types of game objects such as player entities,
		// skill effects, mob entities, and environmental entities.

		for (Fireball fireball : logicdata.fireballs) {
			renderFireblast(fireball, fireball.x, fireball.y);
		}
	}

}
