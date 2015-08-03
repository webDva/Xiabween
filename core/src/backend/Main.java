package backend;

import xiaren.GameScreen;

import com.badlogic.gdx.Game;

public class Main extends Game {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		setScreen(new GameScreen());

	}

	@Override
	public void render() {
		super.render();
	}

}
