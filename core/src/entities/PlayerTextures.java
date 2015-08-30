package entities;

import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class PlayerTextures {

	public TextureAtlas SpriteSheet;
	public Map<String, AtlasRegion> Directions;
	public Map<String, List<AtlasRegion>> Animations;

	public PlayerTextures(TextureAtlas sprite_sheet) {
		this.SpriteSheet = sprite_sheet;
	}

}
