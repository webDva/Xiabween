package xidecsc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Map_struct;
import entities.XiaEntity;
import player.ActualPlayerClass;
import player.HumanPlayer;
import render_subsystem.Loader;

/**
 * Functions as an internal database, holding a list of players, maps, etc. A
 * {@link XIDECSCComponent}.
 *
 * @author sorcerer
 *
 */
public class XiabweenInternalDatabase {

	private List<ActualPlayerClass> allPlayers;
	/**
	 * A mapping of {@link ActualPlayerClass}s and {@link XiaEntity}s.
	 */
	public Map<ActualPlayerClass, XiaEntity> bindingTextures;
	/**
	 * The map structure to load and use. There'll only be one map to use at a
	 * time. Load new maps here as you switch maps.
	 */
	public Map_struct map;

	/**
	 * The human's player. <code>null</code> if the XID instance is a networked
	 * server one. Use {@link #setHumansPlayer(HumanPlayer)} to change the
	 * value.
	 */
	public HumanPlayer humansPlayer;

	public XiabweenInternalDatabase() {
		this.allPlayers = new ArrayList<ActualPlayerClass>();
		this.bindingTextures = new HashMap<ActualPlayerClass, XiaEntity>();
		this.map = new Map_struct();
		this.humansPlayer = null;
	}

	public ArrayList<ActualPlayerClass> getAllPlayers() {
		ArrayList<ActualPlayerClass> players = new ArrayList<ActualPlayerClass>();
		for (ActualPlayerClass entry : this.allPlayers) {
			players.add(entry);
		}
		return players;
	}

	public void addPlayerToDatabase(ActualPlayerClass player) {
		this.allPlayers.add(player);
	}

	/**
	 * Removes an {@link ActualPlayerClass} from a XID instance.
	 *
	 * @param player
	 *            The {@link ActualPlayerClass} object to remove from the XID.
	 * @return <code>true</code> if successful.
	 */
	public boolean removePlayerFromDatabase(ActualPlayerClass player) {
		return this.allPlayers.remove(player);
	}

	/**
	 * @param player
	 *            The human player's character for the camera to follow and
	 *            such.
	 */
	public void setHumansPlayer(HumanPlayer player) {
		this.humansPlayer = player;
	}

	public void useMap(String mapPath) {
		Loader.loadMap(mapPath, this.map);
	}

}
