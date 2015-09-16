package xidecsc;

import player.HumanPlayer;
import player.StatsClass;

/**
 * Responsible for creating players, map data, and anything game logic related.
 * A {@link XIDECSCComponent}.
 *
 * @author sorcerer
 *
 */
public class ExistenceCreator {

	public HumanPlayer createNewHumanPlayer(float x, float y, float initialDirection, String name, String texturePath, StatsClass stats) {
		HumanPlayer newHumanPlayer = new HumanPlayer();

		newHumanPlayer.x = x;
		newHumanPlayer.y = y;

		newHumanPlayer.radians_Direction = initialDirection;
		newHumanPlayer.playerName = name;
		newHumanPlayer.texturePath = texturePath;
		newHumanPlayer.stats = stats;

		return newHumanPlayer;
	}

}
