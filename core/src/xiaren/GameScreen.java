package xiaren;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

	public static final int windowwidth = 1024;
	public static final int windowheight = 768;

	public Texture player;
	public Texture background;

	private OrthographicCamera camera;

	private SpriteBatch playerbatch;
	private SpriteBatch backgroundbatch;

	public PlayerRender shana;
	public XiaRen renderer = new XiaRen();

	@Override
	public void show() {
		shana = new PlayerRender("shana", "64x64shana.png", 100, 100);
		player = renderer.loadPlayerTexture(shana);
		background = new Texture("xbbackground.png");

		camera = new OrthographicCamera();
		camera.setToOrtho(false, windowwidth, windowheight);

		playerbatch = new SpriteBatch();
		backgroundbatch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		backgroundbatch.setProjectionMatrix(camera.combined);
		backgroundbatch.begin();
		backgroundbatch.draw(background, 0, 0);
		backgroundbatch.end();

		playerbatch.begin();
		shana.xcoord = 500;
		shana.ycoord = 100;
		playerbatch.draw(player, shana.xcoord, shana.ycoord);
		playerbatch.end();

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
	}

}
