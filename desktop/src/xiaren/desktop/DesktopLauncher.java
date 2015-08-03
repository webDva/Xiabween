package xiaren.desktop;

import backend.Main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Xiabween";
		config.width = 1024;
		config.height = 768;

		new LwjglApplication(new Main(), config);
	}
}
