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

package logic_server;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import entities.PlayerEntity;

/**
 * Handles collision detection.
 *
 * @author sorcerer
 *
 */
public class CollisionDetector {

	public static final int FEET_HEIGHT = 7;
	/**
	 * The size of the area for getting the subset of collidables in a map. This
	 * might have to be mutable.
	 */
	protected static final float SIZE_AREA = 10;

	/**
	 * Determines if two objects will collide. The first is usually a moving
	 * object while the second is stationary, like a tile.
	 *
	 * TODO: Use only a collision layer to not iterate over a lot of stuff.
	 *
	 * @param playerRectangle
	 *            Uses the bottom portion (feet area) of the
	 *            {@link PlayerEntity}'s rectangle.
	 * @param displacement
	 *            The displacement the {@link PlayerEntity} wants to move by.
	 * @return true if the two objects will collide with each other.
	 */
	public static boolean willPlayerCollide(Rectangle playerRectangle, Vector2 displacement, TiledMap map) {
		Rectangle feet = new Rectangle(playerRectangle.x + displacement.x, playerRectangle.y + displacement.y, playerRectangle.width, FEET_HEIGHT);

		MapLayer objects_layer = map.getLayers().get("objects_layer");
		Array<RectangleMapObject> all_objects = objects_layer.getObjects().getByType(RectangleMapObject.class);
		List<RectangleMapObject> collidables = new ArrayList<RectangleMapObject>();

		for (RectangleMapObject object : all_objects) {
			if ("true" == object.getProperties().get("collidable")) {
				collidables.add(object);
			}
		}

		for (RectangleMapObject rectangle_object : collidables) {
			if (Intersector.overlaps(feet, rectangle_object.getRectangle())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * To prevent cheating, this method gets only a subset of collidable
	 * objects, instead than all of them, in a map. It will get the objects that
	 * are close to the player or object whose collision needs to be checked.
	 *
	 * @param coordinates
	 *            The center of the area to check for collidable objects.
	 * @param map
	 *            The map that the object lives on.
	 * @return A collection of a subset of collidable objects in the map, or
	 *         <code>null</code> if none.
	 */
	public static Array<RectangleMapObject> getSubSetCollidables(Vector2 coordinates, TiledMap map) {
		return null;
	}

	/**
	 * Converts from the tiled coordinates of a .tmx map to libgdx's
	 * coordinates.
	 *
	 * @param tileCoordinates
	 *            The coordinates of the tile. Should be whole numbers (
	 *            {@link Integer}s).
	 * @return the converted game coordinates of the center of the tile.
	 * @param tileWidth
	 *            The width of an individual tile.
	 * @param tileHeight
	 *            The height of an individual tile.
	 * @param mapHeight
	 *            The height of the spot's map in tiles.
	 */
	public static Vector2 convertTileToGameCoordinates(Vector2 tileCoordinates, int tileWidth, int tileHeight, int mapHeight) {
		Vector2 newCoordinates = new Vector2();

		newCoordinates.x = (tileCoordinates.x * tileWidth) + (tileWidth / 2);
		newCoordinates.y = ((mapHeight - tileCoordinates.y - 1) * tileHeight) + (tileHeight / 2);

		return newCoordinates;
	}

	/**
	 * Converts from game coordinates to whole number tiled coordinates.
	 *
	 * @param gameCoordinates
	 *            Game coordinates.
	 * @return the converted tile coordinates in {@link Integer}s.
	 * @param tileWidth
	 *            The width of an individual tile.
	 * @param tileHeight
	 *            The height of an individual tile.
	 * @param mapHeight
	 *            The height of the tile's map in tiles.
	 */
	public static Vector2 convertGameToTileCoordinates(Vector2 gameCoordinates, int tileWidth, int tileHeight, int mapHeight) {
		Vector2 newCoordinates = new Vector2();

		newCoordinates.x = ((int) gameCoordinates.x / tileWidth);
		newCoordinates.y = mapHeight - ((int) (gameCoordinates.y / tileHeight)) - 1;

		return newCoordinates;
	}
}
