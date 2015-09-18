package render_subsystem;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

import backend.Main;
import entities.Map_struct;
import logic_subsystem.GameMaster;

/* TODO: Once the architecture is finished being created, PlayScreen will just ask the logic servers to create players for it instead of
 * it having to create them itself. Then all it needs to do is probably read a file containing game data to give to the logic servers.
 */
public class PlayScreen implements Screen {

	// Don't let there be any textures here and let the Renderer take care of those things.

	public static final String windowTitle = "Xiabween";
	public static int windowWidth = 840;
	public static int windowHeight = 800;

	public static int viewPortWidth = 600, viewPortHeight = 600;

	public Main game;

	private GameMaster gm;

	public PlayScreen(final Main g) {
		this.game = g;
	}

	@Override
	public void show() {

		gm = new GameMaster();
		gm.setCameraZoom(viewPortWidth, viewPortHeight);

		gm.addPlayerToGame(new Vector2(0, 0), 3 * Math.PI / 2, "shana", "shana_final.atlas", null);
		gm.addPlayerToGame(new Vector2(100, 100), 3 * Math.PI / 2, "pink", "pinkwitch.atlas", null);

		onlymap = new Map_struct("grass.tmx");
		determinator.maps.add(onlymap);
		Loader.loadMaps(determinator.maps);

		shana = determinator.registerNewPlayer("shana", "shana_final.atlas", renderer, new Vector2(0, 0));
		determinator.setCurrentPlayerCharacter(shana);
		player2 = determinator.registerNewPlayer("pink haired witch", "pinkwitch.atlas", renderer, new Vector2(100, 100));

		renderer.setCurrentMap(determinator.maps.get(0));
		renderer.followEntity(determinator.myPlayer);

	}

	@Override
	public void render(float delta) {
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
