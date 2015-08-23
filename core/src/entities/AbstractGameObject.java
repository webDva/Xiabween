package entities;

import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class AbstractGameObject {

	public Vector2 position;
	public Vector2 dimension;
	public Vector2 origin;
	public Vector2 scale;
	public float rotation;

	public Texture texture;

	public Map<String, TextureAtlas.AtlasRegion> faces;
	public String direction; // Should make this an enumeration with radians.

	public TextureAtlas animations;
}
