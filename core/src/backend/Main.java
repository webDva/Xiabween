package backend;

import render.PlayScreen;

import com.badlogic.gdx.Game;

public class Main extends Game {

	public static final String title = "Xiabween";
	public static int WIDTH = 1024, HEIGHT = 768;

	public Main() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}
}
