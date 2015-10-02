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
	
		// Play a card
		if (gotLeftClicked(game) && card == null) {
			playCard(game, game.getCardOnMouse(), true);
		}
	}
	
	protected void playCard(LoudWeek game, Card card, boolean isHumanPlayer) {
		
		// Dropping a card on the board
		this.setCard(card);
		card.setPlayed(true);
		game.setCardOnMouse(null);
		
		// Get the cards around it
		Slot leftSlot, rightSlot, upSlot, downSlot;
		int statPlayed, statAgainst;
		
		// Defense
		int left = boardX - 1;
		if (left >= 0) {
			leftSlot = game.getBoard().getSlots()[left][boardY];
			
			Card vsCard = leftSlot.getCard();
			if (vsCard != null) {
				
				statPlayed = card.getDefense();
				statAgainst = vsCard.getStrength();
				
				if (statPlayed > statAgainst) {
					vsCard.setHumanOwner(isHumanPlayer);
				}
			}
		}
		
		// Strength
		int right = boardX + 1;
		if (right < 3) {
			rightSlot = game.getBoard().getSlots()[right][boardY];
			
			Card vsCard = rightSlot.getCard();
			if (vsCard != null) {
			
				statPlayed = card.getStrength();
				statAgainst = vsCard.getDefense();
				
				if (statPlayed > statAgainst) {
					vsCard.setHumanOwner(isHumanPlayer);
				}
			}
		}
		
		// Agility
		int up = boardY + 1;
		if (up < 3) {
			upSlot = game.getBoard().getSlots()[boardX][up];
			
			Card vsCard = upSlot.getCard();
			if (vsCard != null) {
				
				statPlayed = card.getAgility();
				statAgainst = vsCard.getLife();
				
				if (statPlayed > statAgainst) {
					vsCard.setHumanOwner(isHumanPlayer);
				}
			}
		}
		
		// Life
		int down = boardY - 1;
		if (down >= 0) {
			downSlot = game.getBoard().getSlots()[boardX][down];
			
			Card vsCard = downSlot.getCard();
			if (vsCard != null) {
			
				statPlayed = card.getLife();
				statAgainst = vsCard.getAgility();
				
				if (statPlayed > statAgainst) {
					vsCard.setHumanOwner(isHumanPlayer);
				}	
			}
		}
		
		// Pass Turn
		game.getMatch().passTurn();
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
			font.drawWhiteFont("boardX: " + boardX, x, y + Card.cardHeight, true);
			font.drawWhiteFont("boardY: " + boardY, x, y - 20f + Card.cardHeight, true);
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

