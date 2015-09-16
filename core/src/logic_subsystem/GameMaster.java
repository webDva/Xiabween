package logic_subsystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;
import player.ActualPlayerClass;
import player.HumanPlayer;
import player.StatsClass;
import render_subsystem.Loader;
import render_subsystem.Renderer;
import xidecsc.ExistenceCreator;
import xidecsc.StateContainer;
import xidecsc.XiabweenInternalDatabase;

public class GameMaster {

	protected XiabweenInternalDatabase database;
	protected ExistenceCreator creator;
	protected StateContainer container;

	protected Renderer renderer;

	public GameMaster() {
		this.database = new XiabweenInternalDatabase();
		this.creator = new ExistenceCreator();
		this.container = new StateContainer();

		this.renderer = new Renderer();
	}

	// Finally, some very high level abstraction.
	/**
	 * Adds a new player to the game. Also internally adds a player to the
	 * internal database.
	 *
	 * @param spawnLocation
	 *            Player's spawning location that it will be born in.
	 * @param initialDirection
	 *            Player's initial direction it will face.
	 * @param name
	 *            The character's name that will appear in game.
	 * @param texturePath
	 *            The sprite sheet file to be used by the player.
	 * @param stats
	 *            A structure of the player's stats.
	 * @return
	 */
	public void addPlayerToGame(Vector2 spawnLocation, float initialDirection, String name, String texturePath, StatsClass stats) {
		database.addPlayerToDatabase(new HumanPlayer(spawnLocation.x, spawnLocation.y, initialDirection, name, texturePath, stats));
	}

	public void removePlayerFromGame(HumanPlayer player) throws IllegalAccessException {
		if (!database.removePlayerFromDatabase(player)) {
			throw new IllegalAccessException();
		}
	}

	public PlayerEntity loadPlayerTexture(ActualPlayerClass player, String texturePath) {
		PlayerEntity newPlayerEntity = new PlayerEntity(player.playerName, new Vector2(player.x, player.y));
		newPlayerEntity.textures = Loader.loadPlayerAtlas(texturePath, renderer.gpu_keeper);
		newPlayerEntity.playerRectangle = new Rectangle(newPlayerEntity.position.x, newPlayerEntity.position.y,
				newPlayerEntity.textures.Directions.get(newPlayerEntity.direction).getRegionWidth() * Renderer.SPRITE_SCALING_FACTOR,
				newPlayerEntity.textures.Directions.get(newPlayerEntity.direction).getRegionHeight() * Renderer.SPRITE_SCALING_FACTOR);
		return newPlayerEntity;
		/*
		 * Stop at this point. Don't automatically add the XiaEntity to the
		 * rendering list. Do that somewhere else, because game logic may not
		 * call for a newly created entity to be rendered immediately.
		 */
	}

	public void setCameraZoom(int cameraWidth, int cameraHeight) {
		this.renderer.setCameraViewPorts(cameraWidth, cameraHeight);
	}

	public void processStates() {
	}

	public void renderStates() {
	}

	public void loop() {
		processStates();
		renderStates();
	}

	public void disposeOpenGLObjects() {
		this.renderer.gpu_keeper.delete();
	}

	public void checkIfMovementKeyIsPressed() {
		if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.A)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					Math.PI, PlayerEntity.LEFT, new Vector2(-1, 1));
		} else if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					0 * Math.PI, PlayerEntity.RIGHT, new Vector2(1, 1));
		}

		else if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					Math.PI, PlayerEntity.LEFT, new Vector2(-1, -1));
		} else if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.D)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					0 * Math.PI, PlayerEntity.RIGHT, new Vector2(1, -1));
		}

		else if (Gdx.input.isKeyPressed(Keys.W)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					Math.PI / 2, PlayerEntity.UP, new Vector2(0, 1));
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					Math.PI, PlayerEntity.LEFT, new Vector2(-1, 0));
		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					3 * Math.PI / 2, PlayerEntity.DOWN, new Vector2(0, -1));
		} else if (Gdx.input.isKeyPressed(Keys.D)) {
			container.movePlayer((ActualPlayerClass) (database.humansPlayer), (PlayerEntity) database.bindingTextures.get(database.humansPlayer),
					0 * Math.PI, PlayerEntity.RIGHT, new Vector2(1, 0));
		}
	}

}
