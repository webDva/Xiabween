package backend;

import java.util.ArrayList;
import java.util.List;

import entities.Fireball;
import entities.PlayerCharacter;

public class Logician { // The supreme class to handle game logic.

	public List<PlayerCharacter> players;
	public List<Fireball> fireballs;

	public int keypress;
	public PlayerCharacter myPlayer; // The human player's character.

	public Logician() {

		this.players = new ArrayList<PlayerCharacter>();
		this.fireballs = new ArrayList<Fireball>();

		myPlayer = new PlayerCharacter();
	}

	public void setCurrentPlayerCharacter(PlayerCharacter player) { // This is for setting the player's character for the camera to follow.
		this.myPlayer = player;
	}

	public void processStates() {
		keypress = Control.checkIfMovementKeyIsPressed();
		Control.doIfKeyIsPressed(keypress, this.players.get(0)); // Will just do the first and only player for now.
	}

}
