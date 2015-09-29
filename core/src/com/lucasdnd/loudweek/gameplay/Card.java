package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Card {
	
	private SpriteBatch batch;
	private Texture texture;
	
	public final static int cardWidth = 141;
	public final static int cardHeight = 181;
	
	public Card(Texture texture) {
		batch = new SpriteBatch();
		this.texture = texture;
	}
	
	public void update() {
		
	}
	
	public void render(float x, float y) {
		batch.begin();
		batch.draw(texture, x, y);
		batch.end();
	}
}
