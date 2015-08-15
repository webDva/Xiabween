package desktop;

import render.PlayScreen;
import backend.Main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = PlayScreen.windowTitle;
		config.width = PlayScreen.windowWidth;
		config.height = PlayScreen.windowHeight;

		new LwjglApplication(new Main(), config);
	}
}
