package render;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import entities.Map_struct;
import entities.PlayerCharacter;
import entities.PlayerTextures;

public class Loader {

	public static Texture loadTexture(String path, Renderer renderer) {
		Texture texture = new Texture(path);
		renderer.gpu_keeper.textures.add(texture);
		return new Texture(path);
	}

	public static TextureAtlas loadTextureAtlas(String path, Renderer renderer) {
		TextureAtlas atlas = new TextureAtlas(path);
		renderer.gpu_keeper.atlases.add(atlas);
		return new TextureAtlas(path);
	}

	public static void loadMaps(List<Map_struct> mapStructs) {
		// Load all the tiled maps that belong to the Screen class caller that it has supplied to the Renderer.
		for (Map_struct struct : mapStructs) {
			struct.map = new TmxMapLoader().load(struct.filepath);
			struct.mapRenderer = new OrthogonalTiledMapRenderer(struct.map);
		}
	}

	public static PlayerTextures loadPlayerAtlas(String atlasPath, Renderer renderer) {
		TextureAtlas newAtlas = new TextureAtlas(atlasPath);
		renderer.gpu_keeper.atlases.add(newAtlas);

		PlayerTextures textures_object = new PlayerTextures(newAtlas);

		for (AtlasRegion newRegion : textures_object.SpriteSheet.getRegions()) {
			if (newRegion.name != PlayerCharacter.DOWN || newRegion.name != PlayerCharacter.UP
					|| newRegion.name != PlayerCharacter.RIGHT || newRegion.name != PlayerCharacter.LEFT)
				continue;
			textures_object.Directions.put(newRegion.name, textures_object.SpriteSheet.findRegion(newRegion.name));
		}

		Map<String, TextureAtlas.AtlasRegion> newMap = new HashMap<String, TextureAtlas.AtlasRegion>();

		for (TextureAtlas.AtlasRegion newRegion : newAtlas.getRegions()) {
			newMap.put(newRegion.name, newAtlas.findRegion(newRegion.name));
		}

	}
}
