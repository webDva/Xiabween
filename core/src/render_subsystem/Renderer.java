package render_subsystem;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import entities.Fireball;
import entities.Map_struct;
import entities.PlayerEntity;
import entities.XiaEntity;
import logic_subsystem.CollisionDetector;

public class Renderer {

	private SpriteBatch batch;
	private OrthographicCamera camera;

	private Map_struct currentMap;
	private float seconds_lastFrameElapsed = 0;
	public GPUKeeper gpu_keeper;
	private List<XiaEntity> renderingList;

	public static final float SPRITE_SCALING_FACTOR = 1.5f;

	private ZBuffer depthBuffer;

	private enum RenderingType {
		DRAW_IDLE_PLAYER, DRAW_ANIMATING_PLAYER
	}

	public Renderer() {
		this.batch = new SpriteBatch();
		this.gpu_keeper = new GPUKeeper();
		this.gpu_keeper.batches.add(this.batch);
		this.camera = new OrthographicCamera();
		this.renderingList = new ArrayList<XiaEntity>();
		this.depthBuffer = new ZBuffer();
	}

	public void renderPlayer(RenderingType typeToRender, Batch batch, PlayerEntity playerinfo, boolean drawRectangles) {

		if (drawRectangles) {
			ShapeRenderer shaperen = new ShapeRenderer();
			shaperen.setProjectionMatrix(camera.combined);
			shaperen.begin(ShapeType.Filled);
			shaperen.set(ShapeType.Filled);
			shaperen.setColor(Color.RED);
			shaperen.rect(playerinfo.playerRectangle.x, playerinfo.playerRectangle.y, playerinfo.playerRectangle.width,
					playerinfo.playerRectangle.height);

			shaperen.setColor(Color.CYAN);
			shaperen.rect(playerinfo.playerRectangle.x, playerinfo.playerRectangle.y, playerinfo.playerRectangle.width,
					CollisionDetector.FEET_HEIGHT);

			shaperen.end();
		}

		switch (typeToRender) {
		case DRAW_IDLE_PLAYER:
			drawIdlePlayer(batch, playerinfo);
			break;
		case DRAW_ANIMATING_PLAYER:
			drawAnimatingPlayer(batch, playerinfo);
			break;
		}
	}

	public void drawIdlePlayer(Batch batch, PlayerEntity playerinfo) {
		batch.begin();
		batch.draw(playerinfo.textures.Directions.get(playerinfo.direction), playerinfo.position.x, playerinfo.position.y,
				playerinfo.textures.Directions.get(playerinfo.direction).getRegionWidth() * SPRITE_SCALING_FACTOR,
				playerinfo.textures.Directions.get(playerinfo.direction).getRegionHeight() * SPRITE_SCALING_FACTOR);
		batch.end();
	}

	public void drawAnimatingPlayer(Batch batch, PlayerEntity player) {
		Animation animation = new Animation(1 / 15f, player.textures.Animations.get(player.direction + "walk"));

		batch.begin();
		seconds_lastFrameElapsed += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(seconds_lastFrameElapsed, true), player.position.x, player.position.y,
				animation.getKeyFrame(seconds_lastFrameElapsed).getRegionWidth() * SPRITE_SCALING_FACTOR,
				animation.getKeyFrame(seconds_lastFrameElapsed).getRegionHeight() * SPRITE_SCALING_FACTOR);
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

	// TODO: Have a way to tell a Renderer object from a caller to control a camera based on the requests of a caller.
	public void renderStates() { // Will act as a main rendering loop.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		currentMap.mapRenderer.setView(camera);
		currentMap.mapRenderer.render(); // TODO: Note that this renders all layers at once and will thus probably change so that
											// layers can be rendered one at a time, maybe?

		depthBuffer.orderObjects(renderingList);

		for (XiaEntity object : depthBuffer.rendering_objects) {
			if (object instanceof PlayerEntity) {
				if (((PlayerEntity) object).isAnimating) {
					renderPlayer(RenderingType.DRAW_ANIMATING_PLAYER, currentMap.mapRenderer.getBatch(), ((PlayerEntity) object), false);
					continue;
				}
				renderPlayer(RenderingType.DRAW_IDLE_PLAYER, currentMap.mapRenderer.getBatch(), ((PlayerEntity) object), false);
			}

			if (object instanceof Fireball) {
				renderFireblast(((Fireball) object), ((Fireball) object).position.x, ((Fireball) object).position.y);
			}
		}

		/* Remove this eventually with something more robust and clean. */
		this.camera.position.set(renderingList.get(0).position, 0);
		this.camera.update();
	}

	public void addToGPUKeeper(TextureAtlas atlas, Texture texture, Batch batch) {
		if (atlas != null) {
			this.gpu_keeper.addAtlas(atlas);
		}
		if (texture != null) {
			this.gpu_keeper.addTexture(texture);
		}
		if (batch != null) {
			this.gpu_keeper.addBatch(batch);
		}
	}

	public void addXiaEntity(XiaEntity entity) {
		this.renderingList.add(entity);
	}

	public void removeXiaEneity(XiaEntity entity) {
		this.renderingList.remove(entity);
	}
}
