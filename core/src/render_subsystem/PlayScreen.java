package render_subsystem;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

import backend.Logician;
import backend.Main;
import entities.Map_struct;
import entities.PlayerEntity;

/* TODO: Once the architecture is finished being created, PlayScreen will just ask the logic servers to create players for it instead of
 * it having to create them itself. Then all it needs to do is probably read a file containing game data to give to the logic servers.
 */
public class PlayScreen implements Screen {

	// Don't let there be any textures here and let the Renderer take care of those things.

	public static final String windowTitle = "Xiabween";
	public static int windowWidth = 840;
	public static int windowHeight = 800;

	public static int viewPortWidth = 600, viewPortHeight = 600;

	public Renderer renderer;

	public PlayerEntity shana, player2;
	public Main game;

	public Logician determinator;

	public Map_struct onlymap;

	public PlayScreen(final Main g) {
		this.game = g;
	}

	@Override
	public void show() { // This is where Xiabween determines what happens initially...

		renderer = new Renderer();
		renderer.setCameraViewPorts(viewPortWidth, viewPortHeight);

		determinator = new Logician();

		onlymap = new Map_struct("grass.tmx"); // TODO: Make a registerNewMap function like the register function below.
		determinator.maps.add(onlymap);
		Loader.loadMaps(determinator.maps);

		shana = determinator.registerNewPlayer("shana", "shana_final.atlas", renderer, new Vector2(0, 0));
		determinator.setCurrentPlayerCharacter(shana);
		player2 = determinator.registerNewPlayer("pink haired witch", "pinkwitch.atlas", renderer, new Vector2(100, 100));

		renderer.setCurrentMap(determinator.maps.get(0));
		renderer.setThingToFollow(determinator.myPlayer);

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
		renderer.gpu_keeper.delete();
	}

}
