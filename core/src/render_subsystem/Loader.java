package render_subsystem;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import entities.Map_struct;
import entities.PlayerEntity;
import entities.PlayerTextures;

public class Loader {

	public static Texture loadTexture(String path, GPUKeeper keeper) {
		Texture texture = new Texture(path);
		keeper.addTexture(texture);
		return new Texture(path);
	}

	public static TextureAtlas loadTextureAtlas(String path, GPUKeeper keeper) {
		TextureAtlas atlas = new TextureAtlas(path);
		keeper.addAtlas(atlas);
		return new TextureAtlas(path);
	}

	/**
	 * Load all the tiled maps that belong to the Screen class caller that it
	 * has supplied to the Renderer.
	 *
	 * @param mapStructs
	 */
	public static void loadMaps(List<Map_struct> mapStructs) {
		for (Map_struct struct : mapStructs) {
			struct.map = new TmxMapLoader().load(struct.filepath);
			struct.mapRenderer = new OrthogonalTiledMapRenderer(struct.map);
		}
	}

	public static PlayerTextures loadPlayerAtlas(String atlasPath, GPUKeeper keeper) {
		PlayerTextures textures_object = new PlayerTextures(atlasPath);
		keeper.addAtlas(textures_object.SpriteSheet);

		for (AtlasRegion region : textures_object.SpriteSheet.getRegions()) {
			if (region.name.equals(PlayerEntity.DOWN) || region.name.equals(PlayerEntity.UP) || region.name.equals(PlayerEntity.RIGHT)
					|| region.name.equals(PlayerEntity.LEFT))
				textures_object.Directions.put(region.name, textures_object.SpriteSheet.findRegion(region.name));
		}

		for (AtlasRegion region : textures_object.SpriteSheet.getRegions()) {
			if (!region.name.equals(PlayerEntity.DOWN) && !region.name.equals(PlayerEntity.UP) && !region.name.equals(PlayerEntity.RIGHT)
					&& !region.name.equals(PlayerEntity.LEFT))
				textures_object.Animations.put(region.name, textures_object.SpriteSheet.findRegions(region.name));

		}
		return textures_object;

	}
}
