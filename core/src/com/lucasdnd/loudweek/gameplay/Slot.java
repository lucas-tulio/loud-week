package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.screens.MatchScreen;

/**
 * An slot where a Card can be played on. The Board has 9 creature slots and 2 field card slots.
 * 
 * @author lucasdnd
 *
 */
public class Slot {
	
	private int boardX, boardY;
	private int type = 0;	// CardModel.CREATURE or CardModel.FIELD
	private boolean humanOwner;
		
	private ShapeRenderer sr;
	private FontUtils font;
	
	private float x, y;
	private Card card;
	
	public Slot(int type, boolean humanOwner, int boardX, int boardY, float x, float y) {
		this.type = type;
		this.humanOwner = humanOwner;
		this.boardX = boardX;
		this.boardY = boardY;
		this.x = x;
		this.y = y;
		font = new FontUtils();
		sr = new ShapeRenderer();
		card = null;
	}
	
	public void update(MatchScreen matchScreen) {
	
		// Play a card on the board
		if (gotLeftClicked(matchScreen) && card == null && matchScreen.getCardOnMouse() != null) {
			
			// Check if it's a normal card or a field card
			if (matchScreen.getCardOnMouse().getType() == CardModel.CREATURE && type == CardModel.CREATURE) {
				playCard(matchScreen, matchScreen.getCardOnMouse(), true);
			} else if (matchScreen.getCardOnMouse().getType() == CardModel.FIELD && type == CardModel.FIELD
					&& humanOwner) {
				playCard(matchScreen, matchScreen.getCardOnMouse(), true);
			}
		}
	}
	
	protected void playCard(MatchScreen matchScreen, Card card, boolean isHumanPlayer) {
		
		// Dropping a card on the board
		this.setCard(card);
		card.setPlayed(true);
		matchScreen.setCardOnMouse(null);
		
		// If it's a field card, it won't fight the cards around it
		if (card.getType() == CardModel.FIELD) {
			matchScreen.getMatch().passTurn();
			return;
		}
		
		// Get the cards around it
		Slot leftSlot, rightSlot, upSlot, downSlot;
		int statPlayed, statAgainst;
		
		// Defense
		int left = boardX - 1;
		if (left >= 0) {
			leftSlot = matchScreen.getBoard().getSlots()[left][boardY];
			
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
			rightSlot = matchScreen.getBoard().getSlots()[right][boardY];
			
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
			upSlot = matchScreen.getBoard().getSlots()[boardX][up];
			
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
			downSlot = matchScreen.getBoard().getSlots()[boardX][down];
			
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
		matchScreen.getMatch().passTurn();
	}
	
	public void render() {
		
		if (card != null) {
			card.render(x, y);
		}
		
		if (LoudWeek.debug) {
			font.drawWhiteFont("boardX: " + boardX, x, y + Card.cardHeight, true);
			font.drawWhiteFont("boardY: " + boardY, x, y - 20f + Card.cardHeight, true);
		}
	}

	private boolean gotLeftClicked(MatchScreen matchScreen) {
		InputHandler input = matchScreen.getGame().getInputHandler();
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
	
	public int getType() {
		return type;
	}
}

