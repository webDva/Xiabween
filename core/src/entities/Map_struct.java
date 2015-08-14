package entities;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map_struct {

	public String path;
	public TiledMap map;
	public OrthogonalTiledMapRenderer mapRenderer;

	public Map_struct(String path) {
		this.path = path;
	}

}
