package logic_subsystem;

/**
 * Even though {@link XiabweenInternalDatabase} holds data, this
 * {@link GameMaster} class too will hold data, so it can't be abstract. After
 * all, {@link GameMaster} will contain a {@link XiabweenInternalDatabase} and
 * the other {@link XIDECSCComponent}s.
 *
 * @author sorcerer
 *
 */
public abstract class GameMaster {

	// Should these three be in a list or class? If in a class, what would it look like and how to use it?
	protected XiabweenInternalDatabase minionXID;
	protected ExistenceCreator minionEC;
	protected StateContainer minionSC;

	public GameMaster() {
		// TODO Auto-generated constructor stub
	}

}
