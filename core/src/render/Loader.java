package render;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
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
}
