package desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import backend.Main;
import render.PlayScreen;

public class DesktopLauncher {

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = PlayScreen.windowTitle;
		config.width = PlayScreen.windowWidth;
		config.height = PlayScreen.windowHeight;

		new LwjglApplication(new Main(), config);
	}
}
