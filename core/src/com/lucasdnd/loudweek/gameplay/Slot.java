package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;

public class Slot {
	
	private ShapeRenderer sr;
	private FontUtils font;
	
	private float x, y;
	private Card card;
	
	public Slot(float x, float y) {
		this.x = x;
		this.y = y;
		font = new FontUtils();
		sr = new ShapeRenderer();
		card = null;
	}
	
	public void update() {
		
		LoudWeek game = (LoudWeek)Gdx.app.getApplicationListener();
		InputHandler input = game.getInputHandler();
		
		if (game.getCardOnMouse() == null && card != null) {
			// Picking up a card
			game.setCardOnMouse(card);
			card = null;
			return;
		} else if (card == null && input.leftMouseJustClicked) {
			// Dropping a card on the board
			card = game.getCardOnMouse();
			game.setCardOnMouse(null);
			return;
		}
	}
	
	public void render() {
		if (card == null) {
			sr.begin(ShapeType.Line);
			sr.setColor(Color.BLACK);
			sr.rect(x, y, Card.cardWidth, Card.cardHeight);
			sr.end();
		} else {
			card.render(x, y);
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}

