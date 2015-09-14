package server_system;

import java.util.List;

/**
 * Stands for Xiabween Game Data and Logic Server (or XGDLS, pronounced
 * zeeg-geed-lis). Functions as a server for clients (e.g., a human player's
 * client) that performs actions based on
 * {@link server_system.XiaMessageRequest}s.
 */
public class XGDLS {

	public final float baseplayer_speed = 1;

	public List<XiaMessageRequest> queue_XiaMessageRequests;

	public void recieveXiaMessageRequest() {
	}

	public boolean processXiaMessageRequest(XiaMessageRequest request) {
		return true;
	}

	/**
	 * For external databases.
	 */
	public void getJSONData() {
	}
}
