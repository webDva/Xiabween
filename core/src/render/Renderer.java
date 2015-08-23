package render;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import backend.Logician;
import entities.AbstractGameObject;
import entities.Fireball;
import entities.Map_struct;
import entities.PlayerCharacter;

public class Renderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;

	public Map_struct currentMap;
	public AbstractGameObject thingToFollow;
	private Animation animation;
	private float elapsedTime = 0;

	public GPUKeeper gpu_keeper;
	public List<AbstractGameObject> thingsToRender;

	public Renderer(boolean createOwnRenders) {
		if (createOwnRenders) {
			this.batch = new SpriteBatch();
			this.gpu_keeper = new GPUKeeper();
			this.gpu_keeper.batches.add(this.batch);
			this.camera = new OrthographicCamera();
		}

		// TODO Should really put all rendering into here (such as loading textures/textureatlases/textureregions)
		// instead of the Screen class.

	}

	// Can be used for each new screen created, so make the arguments a list of things to load, such as:
	// TextureAtlases to load, TextureRegions to load, regular Textures to load, and even Sprites.
	public void loadThings(List<TextureAtlas> texture_atlases, List<TextureRegion> texture_regions,
			List<Texture> textures) {

	}

	public void renderPlayer(Batch batch, PlayerCharacter playerinfo) {
		batch.begin();
		batch.draw(playerinfo.faces.get("faces/" + playerinfo.direction), playerinfo.position.x, playerinfo.position.y,
				64, 64);
		batch.end();
	}

	public void animatePlayer(Batch batch, PlayerCharacter player) {
		if (this.animation == null) {
			this.animation = new Animation(1 / 15f, player.animations.getRegions());
		}

		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), player.position.x, player.position.y, 64, 64);
		batch.end();
	}

	public void renderFireblast(Fireball fireball, float x, float y) {

	}

	public void setCameraViewPorts(int viewWidth, int viewHeight) {
		this.camera.setToOrtho(false, viewWidth, viewHeight);
	}

	public void setCurrentMap(Map_struct map) {
		this.currentMap = map;
	}

	public void setThingToFollow(AbstractGameObject thing) {
		this.thingToFollow = thing;
	}

	// TODO: Have a way to tell a Renderer object from a caller to control a camera based on the requests of a caller.
	public void renderStates(Logician logicdata) { // Will act as a main rendering loop.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		currentMap.mapRenderer.setView(camera);
		currentMap.mapRenderer.render();

		for (PlayerCharacter player : logicdata.players) {
			if (Gdx.input.isKeyPressed(Keys.S) && player == thingToFollow) {
				animatePlayer(currentMap.mapRenderer.getBatch(), logicdata.myPlayer);
				break;
			}
			renderPlayer(currentMap.mapRenderer.getBatch(), player);
		}

		camera.position.set(thingToFollow.position.x + 50, thingToFollow.position.y + 50, 0); // I know that the character is 100 pixels high and wide.
		camera.update();

		// TODO Use an abstract game object that can be generic for all types of game objects such as player entities,
		// skill effects, mob entities, and environmental entities.

		for (Fireball fireball : logicdata.fireballs) {
			renderFireblast(fireball, fireball.position.x, fireball.position.y);
		}
	}

}
