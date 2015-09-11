package logic_subsystem;

import java.util.List;
import java.util.Map;

public class XiabweenInternalDatabase extends XIDECSCComponent {

	protected List<ActualPlayerClass> ourPlayers;
	/**
	 * A dictionary of names and their corresponding textures that they point
	 * to. The key is the reference while the value is the sprite sheet
	 * filename, not including the extension or the file path, e.g., "shana" =>
	 * "shana spritesheet"
	 */
	protected Map<String, String> bindingTextures;
	/**
	 * A dictionary of map names and their corresponding .tmx files.
	 */
	protected Map<String, String> data_Maps;

	public void queryForData() { // TODO: Might want to make XID abstract too with abstract methods for encapsulating, because
									// there might be more than one type of XID, e.g., for single player or multiplayer.
	}

	public ActualPlayerClass addPlayerToDatabase() {
		return null;
	}

}
