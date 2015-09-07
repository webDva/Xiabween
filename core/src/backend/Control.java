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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import entities.PlayerEntity;

public class Control { // Handles input from the player user. This goes into processStates since it deals with game

	// logic.

	public static void checkIfMovementKeyIsPressed(PlayerEntity player) {
		if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.A)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.LEFT, new Vector2(-1, 1));
		} else if (Gdx.input.isKeyPressed(Keys.W) && Gdx.input.isKeyPressed(Keys.D)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.RIGHT, new Vector2(1, 1));
		}

		else if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.A)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.LEFT, new Vector2(-1, -1));
		} else if (Gdx.input.isKeyPressed(Keys.S) && Gdx.input.isKeyPressed(Keys.D)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.RIGHT, new Vector2(1, -1));
		}

		else if (Gdx.input.isKeyPressed(Keys.W)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.UP, new Vector2(0, 1));
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.LEFT, new Vector2(-1, 0));
		} else if (Gdx.input.isKeyPressed(Keys.S)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.DOWN, new Vector2(0, -1));
		} else if (Gdx.input.isKeyPressed(Keys.D)) {
			PlayerEntityHandler.movePlayerEntity(player, PlayerEntity.RIGHT, new Vector2(1, 0));
		}
	}
}
