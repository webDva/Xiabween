package render;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

import backend.Logician;
import backend.Main;
import backend.PlayerHandler;
import entities.Map_struct;
import entities.PlayerCharacter;

public class PlayScreen implements Screen {

	// Don't let there be any textures here and let the Renderer take care of those things.

	public static final String windowTitle = "Xiabween";
	public static int windowWidth = 800;
	public static int windowHeight = 800;

	public Renderer renderer;

	public PlayerCharacter shana, idlecat, pink;
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
		shana = PlayerHandler.createPlayer("shana", new Vector2(0, 0), 100);
		idlecat = PlayerHandler.createPlayer("cat", new Vector2(270, 270), 100);
		pink = PlayerHandler.createPlayer("pink", new Vector2(320, 270), 100);
		determinator.players.add(shana);
		//determinator.players.add(idlecat);
		//determinator.players.add(pink);
		determinator.setCurrentPlayerCharacter(shana);
		//shana.texture = Loader.loadTexture("faces/shanaleft.png");
		shana.faces = Loader.loadCharacterFacesAtlas("faces/faces.atlas");
		shana.animations = Loader.loadTextureAtlas("animate/animate.atlas");
		idlecat.texture = Loader.loadTexture("idlecat.png");
		pink.texture = Loader.loadTexture("cat1purple.png");

		tiledmaps = new ArrayList<Map_struct>();
		onlymap = new Map_struct("grass.tmx");
		tiledmaps.add(onlymap);
		Loader.loadMaps(tiledmaps);

		renderer = new Renderer(true);
		renderer.setCameraViewPorts(400, 400);
		renderer.setCurrentMap(onlymap);
		renderer.setThingToFollow(shana);

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
