package xiaren.desktop;

import xiaren.XiaRen;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Xiabween";
		config.width = XiaRen.windowwidth;
		config.height = XiaRen.windowwidth;

		new LwjglApplication(new XiaRen(), config);
	}
}
