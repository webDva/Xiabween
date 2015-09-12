package logic_subsystem;

import java.util.ArrayList;
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

	public boolean isOnline;
	/**
	 * If the XID instance is of <code>XIDType.OFFLINE</code>, then the game is
	 * in single player mode, else if it's <code>XIDType.ONLINE</code>, then the
	 * game is in online mode.
	 */
	public final XIDType XIDType;
	/**
	 * The human's player. <code>null</code> if the XID instance is a networked
	 * server one.
	 */
	protected ActualPlayerClass humansPlayer;

	public XiabweenInternalDatabase(XIDType type) {
		this.XIDType = type;
	}

	public void queryForData() { // TODO: Might want to make XID abstract too with abstract methods for encapsulating, because
									// there might be more than one type of XID, e.g., for single player or multiplayer.
	}

	public ArrayList<ActualPlayerClass> getPlayers() {
		ArrayList<ActualPlayerClass> players = new ArrayList<ActualPlayerClass>();
		for (ActualPlayerClass entry : this.ourPlayers) {
			players.add(entry);
		}
		return players;
	}

	public void addPlayerToDatabase(ActualPlayerClass player) {
		this.ourPlayers.add(player);
	}

	/**
	 * Removes an {@link ActualPlayerClass} from a XID instance.
	 *
	 * @param player
	 *            The {@link ActualPlayerClass} object to remove from the XID.
	 * @return <code>true</code> if successful.
	 */
	public boolean removePlayerFromDatabase(ActualPlayerClass player) {
		return this.ourPlayers.remove(player);
	}

	public ActualPlayerClass getHumansPlayer() {
		return this.humansPlayer;
	}

	public boolean setHumansPlayer(ActualPlayerClass player) {
		if (this.XIDType == logic_subsystem.XIDType.ONLINE) {
			return false;
		}

		this.humansPlayer = player;
		return true;
	}

}
