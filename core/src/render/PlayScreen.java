package render;

import java.util.ArrayList;
import java.util.List;

import backend.Logician;
import backend.Main;
import backend.PlayerHandler;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

import entities.Map_struct;
import entities.PlayerCharacter;

public class PlayScreen implements Screen {

	// Don't let there be any textures here and let the Renderer take care of those things.

	public static final int windowwidth = 1024;
	public static final int windowheight = 768;

	public Renderer renderer;

	public PlayerCharacter shana;
	public Main game;

	public Logician determinator;

	public Map_struct onlymap;
	public List<Map_struct> tiledmaps;

	public PlayScreen(final Main g) {
		game = g;
	}

	@Override
	public void show() { // This is where Xiabween determines what happens initially...

		determinator = new Logician();
		shana = PlayerHandler.createPlayer("shana", new Vector2(200, 200), 100);
		determinator.players.add(shana);
		determinator.setCurrentPlayerCharacter(shana);
		shana.texture = Loader.loadTexture("shana.png");

		onlymap = new Map_struct("grass.tmx");
		tiledmaps = new ArrayList<Map_struct>();
		tiledmaps.add(onlymap);

		renderer = new Renderer(true, 400, 400);
		renderer.loadMaps(tiledmaps);
		renderer.setCurrentMap(tiledmaps.get(0));

	}

	@Override
	public void render(float delta) { // ..and then from now on.
		// Game logic first...
		determinator.processStates();

		// ...then rendering.
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
