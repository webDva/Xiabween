package logic_subsystem;

public class ExistenceCreator extends XIDECSCComponent {

	protected final XiabweenInternalDatabase myXIDComponent;

	public ExistenceCreator(XiabweenInternalDatabase XIDComponent) {
		this.myXIDComponent = XIDComponent;
	}

	public ActualPlayerClass createNewPlayer(float x, float y, float initialDirection, String name, String texture, MobType type, StatsClass stats) {
		ActualPlayerClass newPlayer = new ActualPlayerClass(type);

		newPlayer.x = x;
		newPlayer.y = y;

		newPlayer.radians_Direction = initialDirection;
		newPlayer.playerName = name;
		newPlayer.associatedTexture = texture;
		newPlayer.stats = stats;

		myXIDComponent.addPlayerToDatabase(newPlayer);

		return newPlayer;

	}

}
