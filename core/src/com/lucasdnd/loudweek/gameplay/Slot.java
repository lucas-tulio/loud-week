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
		
		if (gotLeftClicked() == false) {
			return;
		}
		
		LoudWeek game = (LoudWeek)Gdx.app.getApplicationListener();
		
		if (game.getCardOnMouse() == null && card != null) {
			// Picking up a card
			game.setCardOnMouse(card);
			card = null;
			return;
		} else if (card == null) {
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
		
		font.drawWhiteFont("x: " + x, x, y + Card.cardHeight, true);
		font.drawWhiteFont("y: " + y, x, y + Card.cardHeight - 20f, true);
	}

	private boolean gotLeftClicked() {
		LoudWeek game = (LoudWeek)Gdx.app.getApplicationListener();
		InputHandler input = game.getInputHandler();
		float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
		return (input.leftMouseJustClicked &&
				Gdx.input.getX() >= x && Gdx.input.getX() <= x + Card.cardWidth &&
				mouseY >= y && mouseY <= y + Card.cardHeight);
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

