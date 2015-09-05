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

package backend;

import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;

public class PlayerEntityHandler {

	public static void movePlayerEntity(PlayerEntity player, String direction, Vector2 coordinates) {
		player.direction = direction;
		player.position.x += coordinates.x;
		player.position.y += coordinates.y;

		player.playerRectangle.x = player.position.x;
		player.playerRectangle.y = player.position.y;

		player.isAnimating = true;
	}

	public static PlayerEntity createPlayerEntity(String name, Vector2 coordinates) { // TODO: Create a startpoint using a tiled object.

		PlayerEntity newplayer = new PlayerEntity();

		newplayer.position = new Vector2(coordinates);

		// Don't load the texture here, but instead, load it in a Screen class.

		newplayer.direction = PlayerEntity.DOWN; // Default direction that the player is facing upon creation.
		newplayer.isAnimating = false;

		newplayer.name = name;

		return newplayer;
	}

}
