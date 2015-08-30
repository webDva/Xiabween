package render;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import backend.Logician;
import entities.Fireball;
import entities.Map_struct;
import entities.PlayerCharacter;
import entities.RenderObject;

public class Renderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;

	public Map_struct currentMap;
	public RenderObject thingToFollow;
	private Animation animation;
	private float elapsedTime = 0;

	public GPUKeeper gpu_keeper;
	public List<RenderObject> thingsToRender;

	public static final float SPRITE_SCALING = 1.5f;

	public Renderer() {
		this.batch = new SpriteBatch();
		this.gpu_keeper = new GPUKeeper();
		this.gpu_keeper.batches.add(this.batch);
		this.camera = new OrthographicCamera();
	}

	public void renderPlayer(Batch batch, PlayerCharacter playerinfo) {
		batch.begin();
		batch.draw(playerinfo.textures.Directions.get(playerinfo.direction), playerinfo.position.x,
				playerinfo.position.y,
				playerinfo.textures.Directions.get(playerinfo.direction).getRegionWidth() * SPRITE_SCALING,
				playerinfo.textures.Directions.get(playerinfo.direction).getRegionHeight() * SPRITE_SCALING);
		batch.end();
	}

	public void animatePlayer(Batch batch, PlayerCharacter player) {
		if (this.animation == null) {
			this.animation = new Animation(1 / 15f, player.textures.Animations.get(player.direction + "walk"));
		}

		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), player.position.x, player.position.y);
		batch.end();

		player.isAnimating = false;
	}

	public void renderFireblast(Fireball fireball, float x, float y) {

	}

	public void setCameraViewPorts(int viewWidth, int viewHeight) {
		this.camera.setToOrtho(false, viewWidth, viewHeight);
	}

	public void setCurrentMap(Map_struct map) {
		this.currentMap = map;
	}

	public void setThingToFollow(RenderObject thing) {
		this.thingToFollow = thing;
	}

	// TODO: Have a way to tell a Renderer object from a caller to control a camera based on the requests of a caller.
	public void renderStates(Logician logicdata) { // Will act as a main rendering loop.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		currentMap.mapRenderer.setView(camera);
		currentMap.mapRenderer.render();

		for (PlayerCharacter player : logicdata.players) {
			if (player.isAnimating) {
				animatePlayer(currentMap.mapRenderer.getBatch(), player);
				continue;
			}
			renderPlayer(currentMap.mapRenderer.getBatch(), player);
		}

		camera.position.set(thingToFollow.position.x, thingToFollow.position.y, 0); // Don't Really know what the coordinates refer to.
		camera.update();

		// TODO Use an abstract game object that can be generic for all types of game objects such as player entities,
		// skill effects, mob entities, and environmental entities.

		for (Fireball fireball : logicdata.fireballs) {
			renderFireblast(fireball, fireball.position.x, fireball.position.y);
		}
	}

}
