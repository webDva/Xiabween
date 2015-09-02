package entities;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class PlayerTextures {

	public TextureAtlas SpriteSheet;
	public Map<String, AtlasRegion> Directions;
	public Map<String, Array<AtlasRegion>> Animations;

	public PlayerTextures(String spritesheetPath) {
		this.SpriteSheet = new TextureAtlas(spritesheetPath);
		this.Directions = new HashMap<String, TextureAtlas.AtlasRegion>();
		this.Animations = new HashMap<String, Array<AtlasRegion>>();
	}

}
