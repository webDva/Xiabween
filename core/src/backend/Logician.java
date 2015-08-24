package backend;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import entities.Fireball;
import entities.PlayerCharacter;

public class Logician { // The supreme class to handle game logic.

	public List<PlayerCharacter> players;
	public List<Fireball> fireballs;

	public int keypress;
	public PlayerCharacter myPlayer; // The human player's character.

	public float test_leftright;

	public Logician() {

		this.players = new ArrayList<PlayerCharacter>();
		this.fireballs = new ArrayList<Fireball>();
		this.test_leftright = 10;

	}

	public void setCurrentPlayerCharacter(PlayerCharacter player) { // This is for setting the player's character for the camera to follow.
		this.myPlayer = player;
	}

	public void processStates() {
		if (players.get(1).position.x > 300) {
			players.get(1);
			PlayerHandler.movePlayer(players.get(1), PlayerCharacter.LEFT, new Vector2(-300, 0));
		}
		players.get(1);
		PlayerHandler.movePlayer(players.get(1), PlayerCharacter.LEFT, new Vector2(test_leftright, 0));
		if (test_leftright < 0) {
			test_leftright = 10;
		} else {
			test_leftright--;
		}
		Control.checkIfMovementKeyIsPressed(myPlayer);
	}

}
