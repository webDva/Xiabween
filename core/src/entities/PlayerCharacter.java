package entities;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PlayerCharacter extends AbstractGameObject {

	public String name;
	public float health;

	public Map<String, TextureAtlas.AtlasRegion> faces;
	public String direction; // Should make this an enumeration with radians.

}
