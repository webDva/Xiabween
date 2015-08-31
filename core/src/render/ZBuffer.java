package render;

import java.util.List;

import entities.RenderObject;

public class ZBuffer {

	private List<RenderObject> rendering_objects;

	public void add_RenderObject(RenderObject newObject, float depth) {
		int depth_calculation = 0; // TODO Determine where to put the rendering object.
		this.rendering_objects.add(depth_calculation, newObject);
	}

}
