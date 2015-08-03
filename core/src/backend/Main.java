package backend;

import xiaren.GameScreen;

import com.badlogic.gdx.Game;

public class Main extends Game {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		setScreen(new GameScreen(this));
		// TODO Create batchs, players, and stuff from here instead of doing it in a messy way
		// in the renderer.
	}

	@Override
	public void render() {
		super.render();
	}

}
