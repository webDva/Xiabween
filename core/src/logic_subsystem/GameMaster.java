package logic_subsystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import backend.Control;
import entities.PlayerEntity;
import player.ActualPlayerClass;
import player.HumanPlayer;
import render_subsystem.Loader;
import render_subsystem.Renderer;
import xidecsc.ExistenceCreator;
import xidecsc.StateContainer;
import xidecsc.XiabweenInternalDatabase;

public class GameMaster {

	public XiabweenInternalDatabase database;
	public ExistenceCreator creator;
	public StateContainer container;

	public Renderer renderer;

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
	 * @return
	 */
	public ActualPlayerClass addPlayerToGame(Vector2 spawnLocation, double initialDirection, String name, String texturePath, float speed) {
		ActualPlayerClass newPlayer = new HumanPlayer(spawnLocation.x, spawnLocation.y, initialDirection, name, texturePath, speed);
		this.database.addPlayerToDatabase(newPlayer);
		this.database.bindingTextures.put(newPlayer, loadPlayerTexture(newPlayer, texturePath));
		this.renderer.addXiaEntity(this.database.bindingTextures.get(newPlayer));
		return newPlayer;
	}

	public void removePlayerFromGame(HumanPlayer player) throws IllegalAccessException {
		this.renderer.removeXiaEneity(this.database.bindingTextures.get(player));
		this.database.removePlayerFromDatabase(player);

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
		moveHumansPlayer();
	}

	public void renderStates() {
		this.renderer.renderStates();
	}

	public void loop() {
		processStates();
		renderStates();
	}

	public void disposeOpenGLObjects() {
		this.renderer.gpu_keeper.delete();
	}

	public void moveHumansPlayer() {
		PlayerEntity playersEntity = (PlayerEntity) database.bindingTextures.get(database.humansPlayer);
		Rectangle playersRectangle = playersEntity.playerRectangle;

		if (Gdx.input.isKeyPressed(Bindings.MOVE_UP_KEY)) {
			if (!CollisionDetector.willPlayerCollide(playersRectangle, Control.MOVE_UP, database.map.map))
				container.movePlayer(database.humansPlayer, playersEntity, Math.PI / 2, PlayerEntity.UP, Control.MOVE_UP);
		} else if (Gdx.input.isKeyPressed(Bindings.MOVE_LEFT_KEY)) {
			if (!CollisionDetector.willPlayerCollide(playersRectangle, Control.MOVE_LEFT, database.map.map))
				container.movePlayer(database.humansPlayer, playersEntity, Math.PI, PlayerEntity.LEFT, Control.MOVE_LEFT);
		} else if (Gdx.input.isKeyPressed(Bindings.MOVE_DOWN_KEY)) {
			if (!CollisionDetector.willPlayerCollide(playersRectangle, Control.MOVE_DOWN, database.map.map))
				container.movePlayer(database.humansPlayer, playersEntity, 3 * Math.PI / 2, PlayerEntity.DOWN, Control.MOVE_DOWN);
		} else if (Gdx.input.isKeyPressed(Bindings.MOVE_RIGHT_KEY)) {
			if (!CollisionDetector.willPlayerCollide(playersRectangle, Control.MOVE_RIGHT, database.map.map))
				container.movePlayer(database.humansPlayer, playersEntity, 0 * Math.PI, PlayerEntity.RIGHT, Control.MOVE_RIGHT);
		}
	}

	public void setMap(String mapPath) {
		this.database.useMap(mapPath, this.renderer);
	}

	public void setHumansPlayer(HumanPlayer player) {
		database.setHumansPlayer(player);
	}
}
