package com.lucasdnd.loudweek;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoudWeek extends ApplicationAdapter {
	
	public static final String GAME_NAME = "Besdiário";
	public static final String VERSION = "v0.1.0";
	private boolean debug = true;
	
	// Graphics
	private SpriteBatch batch;
	private Texture abeelha, emptyCard;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		abeelha = Resources.get().abeelha;
		emptyCard = Resources.get().emptyCard;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(145f / 255f, 158f / 255f, 132f / 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(abeelha, 0, 0);
		batch.draw(emptyCard, 100, 200);
		batch.end();
	}
}
