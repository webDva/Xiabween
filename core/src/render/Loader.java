package render;

import java.util.List;

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
		PlayerTextures textures_object = new PlayerTextures(atlasPath);
		renderer.gpu_keeper.atlases.add(textures_object.SpriteSheet);

		for (AtlasRegion region : textures_object.SpriteSheet.getRegions()) {
			if (region.name.equals(PlayerCharacter.DOWN) || region.name.equals(PlayerCharacter.UP) || region.name.equals(PlayerCharacter.RIGHT)
					|| region.name.equals(PlayerCharacter.LEFT))
				textures_object.Directions.put(region.name, textures_object.SpriteSheet.findRegion(region.name));
		}

		for (AtlasRegion region : textures_object.SpriteSheet.getRegions()) {
			if (!region.name.equals(PlayerCharacter.DOWN) && !region.name.equals(PlayerCharacter.UP) && !region.name.equals(PlayerCharacter.RIGHT)
					&& !region.name.equals(PlayerCharacter.LEFT))
				textures_object.Animations.put(region.name, textures_object.SpriteSheet.findRegions(region.name));

		}
		return textures_object;

	}
}
