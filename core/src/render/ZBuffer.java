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
		if (toBeOrdered.isEmpty())
			return;
		this.rendering_objects = new ArrayList<RenderObject>(toBeOrdered);
		for (RenderObject i : new ArrayList<RenderObject>(rendering_objects)) { // Don't know how to use Comparators, so I'll do it the traditional way.
			for (RenderObject j : new ArrayList<RenderObject>(rendering_objects)) {
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