package backend;

import render.PlayScreen;

import com.badlogic.gdx.Game;

public class Main extends Game {

	@Override
	public void create() {
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}
}
