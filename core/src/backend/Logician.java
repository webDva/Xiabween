package backend;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import entities.Fireball;
import entities.Map_struct;
import entities.PlayerEntity;
import render_subsystem.Loader;
import render_subsystem.Renderer;

/**
 * Handles game logic.
 *
 * @author sorcerer
 *
 */
public class Logician {

	public List<PlayerEntity> players;
	public List<Fireball> fireballs;
	public List<Map_struct> maps;

	public PlayerEntity myPlayer; // The human player's character.

	public Logician() {

		this.players = new ArrayList<PlayerEntity>();
		this.fireballs = new ArrayList<Fireball>();
		this.maps = new ArrayList<Map_struct>();

	}

	public void setCurrentPlayerCharacter(PlayerEntity player) { // This is for setting the player's character for the camera to follow.
		this.myPlayer = player;
	}

	public void processStates() {
		PlayerEntityHandler.setEntityHandlerMap(maps.get(0).map);
		Control.checkIfMovementKeyIsPressed(myPlayer);
	}

	public PlayerEntity registerNewPlayer(String name, String atlasPath, Renderer renderer, Vector2 coordinates) {
		PlayerEntity newPlayer = PlayerEntityHandler.createPlayerEntity(name, coordinates);
		newPlayer.textures = Loader.loadPlayerAtlas(atlasPath, renderer.gpu_keeper);
		newPlayer.playerRectangle = new Rectangle(newPlayer.position.x, newPlayer.position.y,
				newPlayer.textures.Directions.get(newPlayer.direction).getRegionWidth() * Renderer.SPRITE_SCALING_FACTOR,
				newPlayer.textures.Directions.get(newPlayer.direction).getRegionHeight() * Renderer.SPRITE_SCALING_FACTOR);
		this.players.add(newPlayer);
		renderer.addXiaEntity(newPlayer);

		return newPlayer;
	}

}
