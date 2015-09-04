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

package render;

import java.util.ArrayList;
import java.util.List;

import backend.Logician;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import entities.Fireball;
import entities.Map_struct;
import entities.PlayerEntity;
import entities.XiaEntity;

public class Renderer {

	public SpriteBatch batch;
	public OrthographicCamera camera;

	public Map_struct currentMap;
	public XiaEntity thingToFollow;
	private Animation animation;
	private float elapsedTime = 0;

	public GPUKeeper gpu_keeper;
	public List<XiaEntity> thingsToRender;

	public static final float SPRITE_SCALING = 1.5f;

	protected ZBuffer depthBuffer;

	public Renderer() {
		this.batch = new SpriteBatch();
		this.gpu_keeper = new GPUKeeper();
		this.gpu_keeper.batches.add(this.batch);
		this.camera = new OrthographicCamera();
		this.thingsToRender = new ArrayList<XiaEntity>();
		this.depthBuffer = new ZBuffer();
	}

	public void renderPlayer(Batch batch, PlayerEntity playerinfo) {
		batch.begin();
		batch.draw(playerinfo.textures.Directions.get(playerinfo.direction), playerinfo.position.x, playerinfo.position.y,
				playerinfo.textures.Directions.get(playerinfo.direction).getRegionWidth() * SPRITE_SCALING,
				playerinfo.textures.Directions.get(playerinfo.direction).getRegionHeight() * SPRITE_SCALING);
		batch.end();
	}

	public void animatePlayer(Batch batch, PlayerEntity player) {
		this.animation = new Animation(1 / 15f, player.textures.Animations.get(player.direction + "walk"));

		batch.begin();
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), player.position.x, player.position.y, animation.getKeyFrame(elapsedTime)
				.getRegionWidth() * SPRITE_SCALING, animation.getKeyFrame(elapsedTime).getRegionHeight() * SPRITE_SCALING);
		batch.end();

		player.isAnimating = false;
	}

	public void renderFireblast(Fireball fireball, float x, float y) {

	}

	public void setCameraViewPorts(int viewWidth, int viewHeight) {
		this.camera.setToOrtho(false, viewWidth, viewHeight);
	}

	public void setCurrentMap(Map_struct map) {
		this.currentMap = map;
	}

	public void setThingToFollow(XiaEntity thing) {
		this.thingToFollow = thing;
	}

	// TODO: Have a way to tell a Renderer object from a caller to control a camera based on the requests of a caller.
	public void renderStates(Logician logicdata) { // Will act as a main rendering loop.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		currentMap.mapRenderer.setView(camera);
		currentMap.mapRenderer.render(); // TODO: Note that this renders all layers at once and will thus probably change so that
											// layers can be rendered one at a time, maybe?

		depthBuffer.orderObjects(thingsToRender);

		for (XiaEntity object : depthBuffer.rendering_objects) {
			if (object instanceof PlayerEntity) {
				if (((PlayerEntity) object).isAnimating) {
					animatePlayer(currentMap.mapRenderer.getBatch(), ((PlayerEntity) object));
					continue;
				}
				renderPlayer(currentMap.mapRenderer.getBatch(), ((PlayerEntity) object));
			}

			if (object instanceof Fireball) {
				renderFireblast(((Fireball) object), ((Fireball) object).position.x, ((Fireball) object).position.y);
			}
		}

		camera.position.set(thingToFollow.position.x, thingToFollow.position.y, 0); // Don't Really know what the coordinates refer to.
		camera.update();

	}

}
