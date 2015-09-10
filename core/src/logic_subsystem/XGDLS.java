/*
    Xiabween
    Copyright (C) 2015  Easterling

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package logic_subsystem;

import java.util.List;

/**
 * Stands for Xiabween Game Data and Logic Server (or XGDLS, pronounced
 * zeeg-geed-lis). Functions as a server for clients (e.g., a human player's
 * client) that performs actions based on
 * {@link logic_subsystem.XiaMessageRequest}s.
 */
public class XGDLS {

	public final float baseplayer_speed = 1;

	public List<XiaMessageRequest> queue_XiaMessageRequests;

	public void recieveXiaMessageRequest() {
	}

	public void processXiaMessageRequest() {
	}

	/**
	 * For external databases.
	 */
	public void getJSONData() {
	}
}
