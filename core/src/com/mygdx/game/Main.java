package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kotcrab.vis.runtime.scene.Scene;
import com.kotcrab.vis.runtime.scene.SceneLoader;
import com.kotcrab.vis.runtime.scene.VisAssetManager;
import com.mygdx.game.Tweens.TweenHandler;
import com.mygdx.game.managers.ButtonManager;
import com.mygdx.game.system.SpriteBoundsCreator;
import com.mygdx.game.system.SpriteBoundsUpdater;


public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	VisAssetManager manager;

	Scene scene;
	String scenePath;
	private Constants CONSTANTS;

	@Override
	public void create () {
		CONSTANTS = new Constants();
		new TweenHandler();
		batch = new SpriteBatch();

		manager = new VisAssetManager(batch);

		SceneLoader.SceneParameter parameter = new SceneLoader.SceneParameter();
		parameter.config.addSystem(new SpriteBoundsCreator());
		parameter.config.addSystem(new SpriteBoundsUpdater());
		parameter.config.addSystem(new ButtonManager(this));

		scenePath = "scene/test.scene";
		scene = manager.loadSceneNow(scenePath, parameter);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		scene.render();
		CONSTANTS.TWEENMANAGER.update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
		scene.resize(width, height);
	}

	@Override
	public void dispose () {
		batch.dispose();
		manager.dispose();
	}
}
