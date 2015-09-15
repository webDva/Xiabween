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

	protected List<TextureAtlas> atlases;
	protected List<Texture> textures;
	protected List<Batch> batches;

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

	public void addAtlas(TextureAtlas atlas) {
		this.atlases.add(atlas);
	}

	public void addTexture(Texture texture) {
		this.textures.add(texture);
	}

	public void addBatch(Batch batch) {
		this.batches.add(batch);
	}
}
