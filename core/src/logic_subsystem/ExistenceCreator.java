package logic_subsystem;

import player.HumanPlayer;
import player.StatsClass;

public class ExistenceCreator extends XIDECSCComponent {

	public static final XIDECSCComponentType type = XIDECSCComponentType.EXISTENCE_CREATOR;

	public HumanPlayer createNewHumanPlayer(float x, float y, float initialDirection, String name, String texture, StatsClass stats,
			XiabweenInternalDatabase XID) {
		HumanPlayer newHumanPlayer = new HumanPlayer();

		newHumanPlayer.x = x;
		newHumanPlayer.y = y;

		newHumanPlayer.radians_Direction = initialDirection;
		newHumanPlayer.playerName = name;
		newHumanPlayer.associatedTexture = texture;
		newHumanPlayer.stats = stats;

		XID.addPlayerToDatabase(newHumanPlayer);

		return newHumanPlayer;

	}

}
