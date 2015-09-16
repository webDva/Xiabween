package player;

public class MobPlayer extends ActualPlayerClass {

	public final MobType mobType = MobType.MOB_PLAYER;

	public MobPlayer(float x, float y, float initialDirection, String name, String texturePath, StatsClass stats) {
		this.x = x;
		this.y = y;
		this.radians_Direction = initialDirection;
		this.playerName = name;
		this.texturePath = texturePath;
		this.stats = stats;
	}

}
