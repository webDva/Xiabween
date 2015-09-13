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
