package player;

public class HumanPlayer extends ActualPlayerClass {

	public final MobType mobType = MobType.HUMAN_PLAYER;

	public HumanPlayer(float x, float y, double initialDirection, String name, String texturePath, StatsClass stats) {
		this.x = x;
		this.y = y;
		this.radians_Direction = initialDirection;
		this.playerName = name;
		this.texturePath = texturePath;
		this.stats = stats;
	}

}
