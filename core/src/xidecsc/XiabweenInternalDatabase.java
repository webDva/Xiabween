package xidecsc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Map_struct;
import entities.PlayerEntity;
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

	protected List<ActualPlayerClass> ourPlayers;
	/**
	 * A mapping of {@link ActualPlayerClass}s and {@link PlayerEntity}s.
	 */
	protected Map<ActualPlayerClass, PlayerEntity> bindingTextures;
	/**
	 * The map structure to load and use. There'll only be one map to use at a
	 * time. Load new maps here as you switch maps.
	 */
	protected Map_struct map;

	/**
	 * The human's player. <code>null</code> if the XID instance is a networked
	 * server one. Use {@link #setHumansPlayer(HumanPlayer)} to change the
	 * value.
	 */
	public HumanPlayer humansPlayer;

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
