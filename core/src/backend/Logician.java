package backend;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

import entities.Fireball;
import entities.PlayerCharacter;
import render.Loader;
import render.Renderer;

public class Logician { // The supreme class to handle game logic.

	public List<PlayerCharacter> players;
	public List<Fireball> fireballs;

	public int keypress;
	public PlayerCharacter myPlayer; // The human player's character.

	public Logician() {

		this.players = new ArrayList<PlayerCharacter>();
		this.fireballs = new ArrayList<Fireball>();

	}

	public void setCurrentPlayerCharacter(PlayerCharacter player) { // This is for setting the player's character for the camera to follow.
		this.myPlayer = player;
	}

	public void processStates() {
		Control.checkIfMovementKeyIsPressed(myPlayer);
	}

	public PlayerCharacter registerNewPlayer(String name, String atlasPath, Renderer renderer, Vector2 coordinates) {
		PlayerCharacter newPlayer = PlayerHandler.createPlayer(name, coordinates);
		newPlayer.textures = Loader.loadPlayerAtlas(atlasPath, renderer);
		this.players.add(newPlayer);
		renderer.thingsToRender.add(newPlayer);

		return newPlayer;
	}

}
