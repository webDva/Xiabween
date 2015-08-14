package render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import backend.Logician;
import backend.Main;
import backend.PlayerHandler;
import entities.PlayerCharacter;

public class PlayScreen implements Screen {

	// Don't let there be any textures here and let the Renderer take care of those things.

	public static final int windowwidth = 1024;
	public static final int windowheight = 768;

	public Renderer renderer;

	public PlayerCharacter shana;
	public Main game;

	public Logician determinator;

	public String backgroundpath = "topdownbackground.png"; // This can and will change with each new level/background
															// to be rendered.

	public PlayScreen(final Main g) {
		game = g;
	}

	@Override
	public void show() { // This is where Xiabween determines what happens initially...

		determinator = new Logician();
		shana = PlayerHandler.createPlayer("shana", 200, 200, 100, determinator, "shana.png");

		renderer = new Renderer(true);
		//renderer.loadBackground(backgroundpath);
	}

	@Override
	public void render(float delta) { // ..and then from now on.
		// Game logic first...
		determinator.processStates();

		// ...then rendering.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // TODO Put these into XiaRen for it to handle cleanly.

		//renderer.renderBackground(0, 0, renderer.batch);
		renderer.renderStates(determinator);

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
