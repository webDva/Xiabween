package xiaren;

import backend.Main;
import backend.PlayerCharacter;
import backend.PlayerHandler;
import backend.XBLogician;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class PlayScreen implements Screen {

	// Don't let there be any textures here and let the Renderer take care of those things.

	public static final int windowwidth = 1024;
	public static final int windowheight = 768;

	public XBRenderer renderer;

	public PlayerCharacter shana;
	public Main game;

	public XBLogician determinator;

	public String backgroundpath = "topdownbackground.png"; // This can and will change with each new level/background
															// to be

	// rendered.

	public PlayScreen(final Main g) {
		game = g;
	}

	@Override
	public void show() { // This is where Xiabween determines what happens initially...

		determinator = new XBLogician();
		shana = PlayerHandler.createPlayer("shana", 0, 0, 100, determinator, "shana.png");

		renderer = new XBRenderer(true);
		renderer.SetCamera(renderer.camera, Main.WIDTH, Main.HEIGHT);

		renderer.loadBackground(backgroundpath);
	}

	@Override
	public void render(float delta) { // ..and then from now on.
		// Game logic first...
		determinator.processStates();

		// ...then rendering.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // TODO Put these into XiaRen for it to handle cleanly.

		renderer.renderBackground(0, 0, renderer.camera, renderer.batch);
		renderer.renderStates(determinator);
		// renderer.renderPlayer(shana, playerbatch, 500, 100);
		// shana.test_scroll(renderer, shana_render, renderer.batch);

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
