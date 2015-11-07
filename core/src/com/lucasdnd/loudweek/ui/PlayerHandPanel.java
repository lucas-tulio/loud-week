package com.lucasdnd.loudweek.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.Resources;
import com.lucasdnd.loudweek.gameplay.Card;

public class PlayerHandPanel {
	
	private float x, y, width, height;
	private final float margin = 32f;
	
	private FontUtils font;
	private SpriteBatch batch;
	private ShapeRenderer uiShapeRenderer;
	
	private Card[] cards;
	private final int cardsInHand = 6;
	
	public PlayerHandPanel(float x, float y) {
		
		this.x = x;
		this.y = y;
		width = Card.cardWidth * 3 + margin * 2;
		height = Card.cardHeight * 3 + margin * 2;
		
		// Basic objects
		font = new FontUtils();
		batch = new SpriteBatch();
		uiShapeRenderer = new ShapeRenderer();
		
		cards = new Card[cardsInHand];
	}
	
	public void update() {
		
	}
	
	public void render() {
		this.update();
		
		// Render cards
		batch.begin();
		for (int i = 0; i < cards.length; i++) {
			
			float posX = x + Card.cardWidth * (i % 2) + margin * (i % 2);
			float posY = (y - Card.cardHeight * (i / 2)) - margin / 2f * (i / 2) - Card.cardHeight;
			
			if (cards[i] == null) {
				batch.setColor(Color.BLACK);
				batch.draw(Resources.get().cardBack, posX, posY);
			} else {
				batch.setColor(Color.WHITE);
				batch.draw(cards[i].getCardTexture().blue, posX, posY);
			}
			
		}
		batch.end();
	}

}
