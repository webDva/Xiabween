package xiaren;

import backend.Main;
import backend.PlayerCharacter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	public static final int windowwidth = 1024;
	public static final int windowheight = 768;

	private OrthographicCamera camera;

	private SpriteBatch playerbatch;
	private SpriteBatch backgroundbatch;

	public PlayerRender shana;
	public BackgroundRender background;
	public XiaRen renderer = new XiaRen();

	public PlayerCharacter player;
	public Main game;

	public GameScreen(final Main g) {
		game = g;
	}

	@Override
	public void show() {
		shana = new PlayerRender("shana", "64x64shana.png", 100, 100);
		background = new BackgroundRender("dusty", "xbbackground.png");

		camera = new OrthographicCamera();
		renderer.SetCamera(camera, windowwidth, windowheight);

		playerbatch = new SpriteBatch();
		backgroundbatch = new SpriteBatch();

		player = new PlayerCharacter(renderer);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // TODO Put these into XiaRen for it to handle cleanly.

		renderer.renderBackground(camera, background, backgroundbatch);
		//renderer.renderPlayer(shana, playerbatch, 500, 100);
		//renderer.scrollPlayer(shana, playerbatch);
		player.scroll(shana, playerbatch);

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
		playerbatch.dispose();
		backgroundbatch.dispose();
	}

}
