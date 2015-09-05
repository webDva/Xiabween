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

import java.util.ArrayList;
import java.util.List;

import render.Loader;
import render.Renderer;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import entities.Fireball;
import entities.PlayerEntity;

/**
 * Handles game logic.
 * 
 * @author sorcerer
 * 
 */
public class Logician {

	public List<PlayerEntity> players;
	public List<Fireball> fireballs;

	public int keypress;
	public PlayerEntity myPlayer; // The human player's character.

	public Logician() {

		this.players = new ArrayList<PlayerEntity>();
		this.fireballs = new ArrayList<Fireball>();

	}

	public void setCurrentPlayerCharacter(PlayerEntity player) { // This is for setting the player's character for the camera to follow.
		this.myPlayer = player;
	}

	public void processStates() {
		Control.checkIfMovementKeyIsPressed(myPlayer);
	}

	public PlayerEntity registerNewPlayer(String name, String atlasPath, Renderer renderer, Vector2 coordinates) {
		PlayerEntity newPlayer = PlayerEntityHandler.createPlayerEntity(name, false, coordinates);
		newPlayer.textures = Loader.loadPlayerAtlas(atlasPath, renderer);
		newPlayer.playerRectangle = new Rectangle(newPlayer.position.x, newPlayer.position.y, newPlayer.textures.Directions.get(newPlayer.direction)
				.getRegionWidth() * Renderer.SPRITE_SCALING, newPlayer.textures.Directions.get(newPlayer.direction).getRegionHeight()
				* Renderer.SPRITE_SCALING);
		this.players.add(newPlayer);
		renderer.thingsToRender.add(newPlayer);

		return newPlayer;
	}

}
