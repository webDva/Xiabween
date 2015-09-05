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

package entities;

import com.badlogic.gdx.math.Rectangle;

/**
 * A Xia struct for rendering a PlayerLogic object.
 * 
 * @author sorcerer
 * 
 */
public class PlayerEntity extends XiaEntity {

	public static final String UP = "north", RIGHT = "east", DOWN = "south", LEFT = "west";

	public String direction; // Should make this an enumeration with radians.
								// Actually, the radians would be better suited for the game logic form of the player class.
	public boolean isAnimating;
	public PlayerTextures textures; // Contains idle and walking animation frames.
	public String name;
	public Rectangle playerRectangle;

}
