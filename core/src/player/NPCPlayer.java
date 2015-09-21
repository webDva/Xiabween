package player;

public class NPCPlayer extends ActualPlayerClass {

	public final MobType mobType = MobType.NPC_PLAYER;

	public NPCPlayer(float x, float y, float initialDirection, String name, String texturePath, float speed) {
		this.x = x;
		this.y = y;
		this.radians_Direction = initialDirection;
		this.playerName = name;
		this.texturePath = texturePath;
		this.speed = speed;
	}

}
