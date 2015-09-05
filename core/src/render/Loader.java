/*
    Xiabween
    Copyright (C) 2015  Easterling

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package render;

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

	public static PlayerTextures loadPlayerAtlas(String atlasPath, Renderer renderer) {
		PlayerTextures textures_object = new PlayerTextures(atlasPath);
		renderer.gpu_keeper.atlases.add(textures_object.SpriteSheet);

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
