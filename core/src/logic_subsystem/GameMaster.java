package logic_subsystem;

import com.badlogic.gdx.math.Vector2;

import player.HumanPlayer;
import player.StatsClass;
import xidecsc.ExistenceCreator;
import xidecsc.StateContainer;
import xidecsc.XiabweenInternalDatabase;

public class GameMaster {

	protected XiabweenInternalDatabase database;
	protected ExistenceCreator creator;
	protected StateContainer container;

	public GameMaster() {
		this.database = new XiabweenInternalDatabase();
		this.creator = new ExistenceCreator();
		this.container = new StateContainer();
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
	 * @param texture
	 * @param stats
	 * @return
	 */
	public HumanPlayer addPlayerToGame(Vector2 spawnLocation, float initialDirection, String name, String texture, StatsClass stats) {
		HumanPlayer newPlayer = creator.createNewHumanPlayer(spawnLocation.x, spawnLocation.y, initialDirection, name, texture, stats);
		database.addPlayerToDatabase(newPlayer);
		return newPlayer;
	}

}
