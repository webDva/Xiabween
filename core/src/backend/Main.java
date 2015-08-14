package backend;

import com.badlogic.gdx.Game;

import render.PlayScreen;

public class Main extends Game {

	public static final String title = "Xiabween";
	public static int WIDTH = 800, HEIGHT = 800;

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
