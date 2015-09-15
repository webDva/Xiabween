package xidecsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import player.ActualPlayerClass;
import player.HumanPlayer;

/**
 * Functions as an internal database, holding a list of players, maps, etc. A
 * {@link XIDECSCComponent}.
 *
 * @author sorcerer
 *
 */
public class XiabweenInternalDatabase {

	protected List<ActualPlayerClass> ourPlayers;
	/**
	 * A dictionary of names and their corresponding textures that they point
	 * to. The key is the reference while the value is the sprite sheet file
	 * path, e.g., "shana" => "shana_spritesheet.png"
	 */
	protected Map<String, String> bindingTextures;
	/**
	 * A dictionary of map names and their corresponding .tmx files.
	 */
	protected Map<String, String> data_Maps;

	/**
	 * The human's player. <code>null</code> if the XID instance is a networked
	 * server one.
	 */
	protected HumanPlayer humansPlayer;

	public XiabweenInternalDatabase() {
		this.humansPlayer = null;
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

	public HumanPlayer getHumansPlayer() {
		return this.humansPlayer;
	}

	public void setHumansPlayer(HumanPlayer player) {
		this.humansPlayer = player;
	}
}
