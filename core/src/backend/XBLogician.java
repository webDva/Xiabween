package backend;

import java.util.ArrayList;
import java.util.List;

public class XBLogician { // The supreme class to handle game logic.

	public List<PlayerCharacter> players;
	public List<Fireball> fireballs;

	public boolean test_up = true;
	public int test_xpos = 0;

	public XBLogician() {

		this.players = new ArrayList<PlayerCharacter>();
		this.fireballs = new ArrayList<Fireball>();

	}

	public void processStates() {
		players.get(0).x = test_xpos;
		players.get(0).y = 245;

		if (this.test_up) {
			if (test_xpos == 500) {
				test_up = false;
				test_xpos--;
			} else {
				test_xpos++;
			}
		} else {
			if (test_xpos == 0) {
				test_up = true;
				test_xpos++;
			} else {
				test_xpos--;
			}
		}
	}

}
