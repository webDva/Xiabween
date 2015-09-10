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

package render_subsystem;

import java.util.ArrayList;
import java.util.List;

import entities.XiaEntity;

public class ZBuffer {

	public List<XiaEntity> rendering_objects;

	public ZBuffer() {
		this.rendering_objects = new ArrayList<XiaEntity>();
	}

	public void orderObjects(List<XiaEntity> toBeOrdered) {
		if (toBeOrdered.isEmpty())
			return;
		this.rendering_objects = new ArrayList<XiaEntity>(toBeOrdered);
		for (XiaEntity i : new ArrayList<XiaEntity>(rendering_objects)) { // Don't know how to use Comparators, so I'll do it the traditional way.
			for (XiaEntity j : new ArrayList<XiaEntity>(rendering_objects)) {
				if (i.position.y > j.position.y && this.rendering_objects.indexOf(i) > this.rendering_objects.indexOf(j)) {
					this.rendering_objects.remove(j);
					if (this.rendering_objects.indexOf(i) == this.rendering_objects.size() - 1) // Have to do this to prevent an index out of bounds error.
						this.rendering_objects.add(j);
					else
						this.rendering_objects.add(this.rendering_objects.indexOf(i) + 1, j);
				}
			}
		}
	}
}