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
		this.rendering_objects = new ArrayList<RenderObject>(toBeOrdered);
		for (RenderObject i : this.rendering_objects) { // Don't know how to use Comparators, so I'll do it the traditional way.
			for (RenderObject j : this.rendering_objects) {
				if (i.position.y < j.position.y) {
					this.rendering_objects.remove(j);
					this.rendering_objects.add(this.rendering_objects.indexOf(i) + 1, j);
				}
			}
		}
	}
}