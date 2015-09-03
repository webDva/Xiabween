package backend;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import entities.Fireball;
import entities.PlayerEntity;
import render.Loader;
import render.Renderer;

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
		PlayerEntity newPlayer = PlayerEntityHandler.createPlayerEntity(name, coordinates);
		newPlayer.textures = Loader.loadPlayerAtlas(atlasPath, renderer);
		this.players.add(newPlayer);
		renderer.thingsToRender.add(newPlayer);

		return newPlayer;
	}

}
