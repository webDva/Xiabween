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

package render_subsystem;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * This is supposed to be a struct to hold GPU memory related objects and to
 * dispose of them.
 * 
 * @author sorcerer
 */
public class GPUKeeper {

	public List<TextureAtlas> atlases;
	public List<Texture> textures;
	public List<Batch> batches;

	public GPUKeeper() {
		this.atlases = new ArrayList<TextureAtlas>();
		this.textures = new ArrayList<Texture>();
		this.batches = new ArrayList<Batch>();
	}

	public void delete() {
		for (TextureAtlas i : atlases) {
			i.dispose();
		}

		for (Texture i : textures) {
			i.dispose();
		}

		for (Batch i : batches) {
			i.dispose();
		}
	}

}
