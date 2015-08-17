package render;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import entities.Map_struct;

public class Loader {

	public static Texture loadTexture(String path) {
		return new Texture(path);
	}

	public static void loadMaps(List<Map_struct> mapStructs) {
		// Load all the tiled maps that belong to the Screen class caller that it has supplied to the Renderer.
		for (Map_struct struct : mapStructs) {
			struct.map = new TmxMapLoader().load(struct.filepath);
			struct.mapRenderer = new OrthogonalTiledMapRenderer(struct.map);
		}
	}

	public static Map<String, Sprite> loadCharacterFacesAtlas(String atlasPath) {
		TextureAtlas newAtlas = new TextureAtlas(atlasPath);
		Map<String, Sprite> newMap = new HashMap<String, Sprite>();

		for (TextureAtlas.AtlasRegion newRegion : newAtlas.getRegions()) {
			newMap.put(newRegion.name, newAtlas.createSprite(newRegion.name));
		}

		return newMap;
	}
}
