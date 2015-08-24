package entities;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

public class RenderObject {

	public Vector2 position;

	public Map<String, TextureAtlas.AtlasRegion> faces;
	public String direction; // Should make this an enumeration with radians.

	public TextureAtlas animations;

	public boolean isAnimating;
}
