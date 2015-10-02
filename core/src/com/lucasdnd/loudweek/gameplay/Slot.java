package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;

public class Slot {
	
	private int boardX, boardY;
	
	private ShapeRenderer sr;
	private FontUtils font;
	
	private float x, y;
	private Card card;
	
	public Slot(int boardX, int boardY, float x, float y) {
		this.boardX = boardX;
		this.boardY = boardY;
		this.x = x;
		this.y = y;
		font = new FontUtils();
		sr = new ShapeRenderer();
		card = null;
	}
	
	public void update(LoudWeek game) {
		
		if (gotLeftClicked(game) == false) {
			return;
		}
		
//		if (game.getCardOnMouse() == null && card != null) {
//			// Picking up a card
//			game.setCardOnMouse(card);
//			card = null;
//			return;
//		} else
		if (card == null) {
		
			// Dropping a card on the board
			card = game.getCardOnMouse();
			card.setPlayed(true);
			game.setCardOnMouse(null);
			
			// Get the cards around it
			Slot leftSlot, rightSlot, upSlot, downSlot;
			
			// Defense
			int left = boardX - 1;
			if (left >= 0) {
				leftSlot = game.getBoard().getSlots()[left][boardY];
				Card vsCard = leftSlot.getCard();
				if (vsCard != null) {
					if (card.getDefense() > vsCard.getDefense()) {
						vsCard.setHumanOwner(true);
					} else if (card.getDefense() < vsCard.getDefense()) {
						vsCard.setHumanOwner(false);
					}
				}
			}
			
			// Strength
			int right = boardX + 1;
			if (right < 3) {
				rightSlot = game.getBoard().getSlots()[right][boardY];
				Card vsCard = rightSlot.getCard();
				if (vsCard != null) {
					if (card.getStrength() > vsCard.getStrength()) {
						vsCard.setHumanOwner(true);
					} else if (card.getStrength() < vsCard.getStrength()) {
						vsCard.setHumanOwner(false);
					}
				}
			}
			
			// Agility
			int up = boardY - 1;
			if (up >= 0) {
				upSlot = game.getBoard().getSlots()[boardX][up];
				Card vsCard = upSlot.getCard();
				if (vsCard != null) {
					if (card.getAgility() > vsCard.getAgility()) {
						vsCard.setHumanOwner(true);
					} else if (card.getAgility() < vsCard.getAgility()) {
						vsCard.setHumanOwner(false);
					}
				}
			}
			
			// Life
			int down = boardY + 1;
			if (down < 3) {
				downSlot = game.getBoard().getSlots()[boardX][down];
				Card vsCard = downSlot.getCard();
				if (vsCard != null) {
					if (card.getLife() > vsCard.getLife()) {
						vsCard.setHumanOwner(true);
					} else if (card.getLife() < vsCard.getLife()) {
						vsCard.setHumanOwner(false);
					}
				}
			}
			
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
		
		if (LoudWeek.debug) {
			font.drawWhiteFont("x: " + x, x, y + Card.cardHeight, true);
			font.drawWhiteFont("y: " + y, x, y + Card.cardHeight - 20f, true);
		}
	}

	private boolean gotLeftClicked(LoudWeek game) {
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

