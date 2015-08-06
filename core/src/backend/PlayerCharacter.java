package backend;

import renderobjects.PlayerRenderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xiaren.XBRenderer;

public class PlayerCharacter {

	private int test_xpos = 0;
	private boolean test_up = true;

	public int x, y; // These aren't for rendering or collision detection, but are for instead actual gameplay mechanics
						// and logic.
	public String name;
	public float health;

	// Let a PlayerCharacterHandler handle the player's initial x, y position and even health.

	public void test_scroll(XBRenderer renderer, PlayerRenderer playerobject, SpriteBatch spritebatch) {
		renderer.renderPlayer(playerobject, spritebatch, test_xpos, 225);
		if (test_up) {
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
