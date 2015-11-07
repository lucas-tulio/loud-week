package com.lucasdnd.loudweek.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.Resources;
import com.lucasdnd.loudweek.gameplay.Card;

public class PlayerHandPanel {
	
	// Layout
	private float x, y, width, height;
	private final float marginX = 12f;
	private final float marginY = 12f;
	
	// Render
	private FontUtils font;
	private SpriteBatch batch;
	private ShapeRenderer uiShapeRenderer;
	
	private Card[] cards;
	private final int maxCardsInHand = 6;
	private Card pickedUpCard;	// This will keep a reference to the card the Player picked up from here.
								// If the cardOnMouse needs to be put back, we know it came from here
	private int pickedUpCardSlot = 0;	// Where the picked up card was
	
	public PlayerHandPanel(float x, float y) {
		
		this.x = x;
		this.y = y;
		width = Card.cardWidth * 2 + marginX;
		height = Card.cardHeight * 3 + marginY * 2;
		
		// Basic objects
		font = new FontUtils();
		batch = new SpriteBatch();
		uiShapeRenderer = new ShapeRenderer();
		
		cards = new Card[maxCardsInHand];
	}
	
	public void update(LoudWeek game) {
		
		InputHandler input = game.getInputHandler();
		
		
		
	}
	
	public void render(LoudWeek game) {
		this.update(game);
		
		// Render cards
		batch.begin();
		for (int i = 0; i < cards.length; i++) {
			
			float posX = x + Card.cardWidth * (i % 2) + marginX * (i % 2);
			float posY = (y - Card.cardHeight * (i / 2)) - marginY / 2f * (i / 2) - Card.cardHeight;
			
			if (cards[i] == null) {
				batch.setColor(Color.BLACK);
				batch.draw(Resources.get().cardBack, posX, posY);
			} else {
				batch.setColor(Color.WHITE);
				batch.draw(cards[i].getCardTexture().blue, posX, posY);
			}
			
		}
		batch.end();
		
		// Render text
		font.drawWhiteFont("Seu deck", x, y + marginY * 3f, true, Align.center, (int)width);
	}
	
	/**
	 * When the player releases the card on the mouse by right clicking it
	 * @param cardOnMouse
	 */
	public void putCardBack(Card cardOnMouse) {
		if (cardOnMouse == pickedUpCard) {
			cards[pickedUpCardSlot] = pickedUpCard;
			pickedUpCard = null;
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getMarginX() {
		return marginX;
	}

	public float getMarginY() {
		return marginY;
	}

	public Card[] getCards() {
		return cards;
	}
	
	public int getMaxCardsInHand() {
		return maxCardsInHand;
	}
	
}
