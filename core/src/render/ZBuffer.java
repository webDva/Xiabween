package render;

import java.util.ArrayList;
import java.util.List;

import entities.RenderObject;

public class ZBuffer {

	public List<RenderObject> rendering_objects;

	public ZBuffer() {
		this.rendering_objects = new ArrayList<RenderObject>();
	}

	public void orderObjects(List<RenderObject> toBeOrdered) {
		this.rendering_objects.clear();
		// The ordering and Z buffer determination goes here:
		RenderObject previousY = null;
		for (RenderObject i : toBeOrdered) { // Don't know how to use Comparators, so I'll do it the traditional way.
			if (previousY == null) {
				this.rendering_objects.add(i);
				continue;
			}
			if (i.position.y < previousY.position.y)
				this.rendering_objects.add(this.rendering_objects.indexOf(previousY), i);
			else
				this.rendering_objects.add(i);
			previousY = i;
		}
	}

}
