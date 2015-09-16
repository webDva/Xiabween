package backend;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;
import logic_subsystem.CollisionDetector;

public class PlayerEntityHandler {

	private static TiledMap handler_map;

	public static void setEntityHandlerMap(TiledMap map) {
		PlayerEntityHandler.handler_map = map;
	}

	public static void movePlayer(PlayerEntity player, String direction, Vector2 coordinates) {
		player.direction = direction;

		// test for collision
		if (CollisionDetector.willPlayerCollide(player.playerRectangle, coordinates, handler_map))
			return;

		player.position.x += coordinates.x;
		player.position.y += coordinates.y;

		player.playerRectangle.x = player.position.x;
		player.playerRectangle.y = player.position.y;

		player.isAnimating = true;
	}

}
