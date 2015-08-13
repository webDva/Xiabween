package desktop;

import backend.Main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Main.title;
		config.width = Main.WIDTH;
		config.height = Main.HEIGHT;

		new LwjglApplication(new Main(), config);
	}
}
