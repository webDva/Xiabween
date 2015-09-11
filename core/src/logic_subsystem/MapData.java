package logic_subsystem;

import java.util.Map;

import com.badlogic.gdx.math.Vector2;

/**
 * Contains, not a tiled map, but the data and attributes that a tiled map would
 * have, such as the dimensions of tiles, the dimensions of the tiled map
 * itself, and maybe even the locations of objects on the tiled map, such as
 * spawn points.
 *
 * @author sorcerer
 *
 */
public class MapData {

	/**
	 * The width and height of an individual tile. Height and width should
	 * usually be the same.
	 */
	private int tileDimensions;
	/**
	 * An {@link Integer} describing the number of tiles that make up the width
	 * and height of the tiled map.
	 */
	private int mapWidth, mapHeight;
	private Map<String, Vector2> locations; // Might need to make this non-private to add to and remove from it unless
											// those methods return a map.

	public int getTileDimensions() {
		return tileDimensions;
	}

	public void setTileDimensions(int tileDimensions) {
		this.tileDimensions = tileDimensions;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	public Map<String, Vector2> getLocations() {
		return locations;
	}

	public void setLocations(Map<String, Vector2> locations) {
		this.locations = locations;
	}

}
