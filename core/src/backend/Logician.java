package backend;

import java.util.ArrayList;
import java.util.List;

public class Logician { // The supreme class to handle game logic.

	public List<PlayerCharacter> players;
	public List<Fireball> fireballs;

	public int keypress;

	public Logician() {

		this.players = new ArrayList<PlayerCharacter>();
		this.fireballs = new ArrayList<Fireball>();

	}

	public void processStates() {
		keypress = Control.checkIfMovementKeyIsPressed();
		Control.doIfKeyIsPressed(keypress, this.players.get(0));
	}

}
