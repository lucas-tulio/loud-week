package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;

public class Card {
	
	private String name = "";
	private String text = "";
	private int strength = 0;
	private int defense = 0;
	private int agility = 0;
	private int life = 0;
	
	private int element = 0;
	private int type = 0;
	
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
