package backend;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import xiaren.PlayerRender;
import xiaren.XiaRen;

public class PlayerCharacter {
	private int xpos = 0;
	private boolean up = true;

	private final XiaRen renderer;

	public PlayerCharacter(XiaRen renderer) {
		this.renderer = renderer;
	}

	public void scroll(PlayerRender playerobject, SpriteBatch spritebatch) {
		renderer.renderPlayer(playerobject, spritebatch, xpos, 225);
		if (up) {
			if (xpos == 500) {
				up = false;
				xpos--;
			} else {
				xpos++;
			}
		} else {
			if (xpos == 0) {
				up = true;
				xpos++;
			} else {
				xpos--;
			}
		}
	}

}
