package logic_subsystem;

public class ExistenceCreator extends XIDECSCComponent {

	public static final XIDECSCComponentType type = XIDECSCComponentType.EXISTENCE_CREATOR;

	public ActualPlayerClass createNewPlayer(float x, float y, float initialDirection, String name, String texture, MobType type, StatsClass stats,
			XiabweenInternalDatabase XID) {
		ActualPlayerClass newPlayer = new ActualPlayerClass(type);

		newPlayer.x = x;
		newPlayer.y = y;

		newPlayer.radians_Direction = initialDirection;
		newPlayer.playerName = name;
		newPlayer.associatedTexture = texture;
		newPlayer.stats = stats;

		XID.addPlayerToDatabase(newPlayer);

		return newPlayer;

	}

}
