package logic_subsystem;

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
	 * @param texture
	 *            The sprite sheet file to be used by the player.
	 * @param stats
	 *            A structure of the player's stats.
	 * @return
	 */
	public void addPlayerToGame(Vector2 spawnLocation, float initialDirection, String name, String texture, StatsClass stats) {
		HumanPlayer newPlayer = creator.createNewHumanPlayer(spawnLocation.x, spawnLocation.y, initialDirection, name, texture, stats);
		database.addPlayerToDatabase(newPlayer);
	}

	public void removePlayerFromGame(HumanPlayer player) throws IllegalAccessException {
		boolean result = database.removePlayerFromDatabase(player);
		if (!result) {
			throw new IllegalAccessException();
		}

	}

	public void associatePlayerTexture(ActualPlayerClass player, String texture) {
		PlayerEntity newEntity = PlayerEntityHandler.createPlayerEntity(player.playerName, new Vector2(player.x, player.y));
		Loader.loadPlayerAtlas(texture, renderer.gpu_keeper);
	}

}
