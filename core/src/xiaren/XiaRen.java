// Forget about what to render right now, and just start rendering.

package xiaren;


import com.badlogic.gdx.graphics.Texture;

public class XiaRen {

	public Texture loadPlayerTexture(PlayerRender playerobject) {
		return new Texture(playerobject.texturepath);
	}

	public void renderPlayer(PlayerRender playerobject) {

	}
}
