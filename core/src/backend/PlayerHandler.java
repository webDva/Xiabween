package backend;

import com.badlogic.gdx.graphics.Texture;

import entities.PlayerCharacter;

public class PlayerHandler {

	public static void movePlayer(PlayerCharacter player, int x, int y) {
		player.x = x;
		player.y = y;
	}

	public static void changeHealth(PlayerCharacter player, float health) {

		player.health = health;
	}

	public static PlayerCharacter createPlayer(String name, int x, int y, float health, Logician logician,
			String texturepath) {

		PlayerCharacter newplayer = new PlayerCharacter();
		newplayer.name = name;
		newplayer.x = x;
		newplayer.y = y;
		newplayer.health = health;

		newplayer.texture = new Texture(texturepath);

		logician.players.add(newplayer);

		return newplayer;
	}

}
