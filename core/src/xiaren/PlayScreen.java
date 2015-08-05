package xiaren;

import renderobjects.BackgroundRenderer;
import renderobjects.PlayerRenderer;
import backend.Main;
import backend.PlayerCharacter;
import backend.XBLogician;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class PlayScreen implements Screen {

	public static final int windowwidth = 1024;
	public static final int windowheight = 768;

	public PlayerRenderer shana;
	public BackgroundRenderer background;
	public XBRenderer renderer;

	public PlayerCharacter player;
	public Main game;

	public PlayScreen(final Main g) {
		game = g;
	}

	@Override
	public void show() {
		renderer = new XBRenderer(true);

		shana = new PlayerRenderer("shana", "64x64shana.png", 100, 100);
		background = new BackgroundRenderer("dusty", "xbbackground.png");

		renderer.SetCamera(renderer.camera, Main.WIDTH, Main.HEIGHT);

		player = new PlayerCharacter("shana");
	}

	@Override
	public void render(float delta) {
		// Game logic first...
		XBLogician.processStates();

		// ...then rendering.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // TODO Put these into XiaRen for it to handle cleanly.

		renderer.renderBackground(renderer.camera, background, renderer.batch);
		// renderer.renderPlayer(shana, playerbatch, 500, 100);
		player.test_scroll(renderer, shana, renderer.batch);

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		renderer.batch.dispose();
	}

}
