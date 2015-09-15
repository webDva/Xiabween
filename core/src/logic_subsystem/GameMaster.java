package logic_subsystem;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import backend.PlayerEntityHandler;
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
		database.addPlayerToDatabase(creator.createNewHumanPlayer(spawnLocation.x, spawnLocation.y, initialDirection, name, texturePath, stats));
	}

	public void removePlayerFromGame(HumanPlayer player) throws IllegalAccessException {
		if (!database.removePlayerFromDatabase(player)) {
			throw new IllegalAccessException();
		}
	}

	public PlayerEntity loadPlayerTexture(ActualPlayerClass player, String texturePath) {
		PlayerEntity newPlayerEntity = PlayerEntityHandler.createPlayerEntity(player.playerName, new Vector2(player.x, player.y));
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

}
