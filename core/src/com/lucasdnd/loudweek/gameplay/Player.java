package com.lucasdnd.loudweek.gameplay;

import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.screens.MatchScreen;

public class Player {
	
	// Position
	private float x, y;
	private final float cardOffsetX = 30f;
	private final float fullHandWidth = Card.cardWidth + (4 * cardOffsetX);
	
	// Cards
	boolean mouseOverHand = false;
	private int hoveredCardId = 0;
	private LinkedList<Card> hand;
	
	FontUtils font;
	
	// Position on the screen
	private int position;
	public class Position {
		public static final int upperLeft = 0;
		public static final int lowerRight = 1;
	}
	
	// Game stuff
	private boolean isHuman = false;
	
	public Player(int position) {
		
		this.position = position;
		if (position == Position.lowerRight) {
			isHuman = true;
		}
		
		hand = new LinkedList<Card>();
		
		if (isHuman) {
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), true));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), true));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), true));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), true));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), true));
		} else {
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), false));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), false));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), false));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), false));
			hand.add(new Card(CardDatabase.get().getRandomCardModel(), false));
		}
		
		if (position == Position.upperLeft) {
			x = 0f;
			y = Gdx.graphics.getHeight() - Card.cardHeight;
		} else {
			x = Gdx.graphics.getWidth() - fullHandWidth;
			y = 0f;
		}
		
		font = new FontUtils();
	}
	
	public void update(MatchScreen matchScreen) {
		
		if (position != Position.lowerRight) {
			return;
		}
		
		// Human player action
		
		if (matchScreen.getMatch().isHumanPlayerturn()) {
		
			InputHandler input = matchScreen.getGame().getInputHandler();
			
			// Mouse over will zoom the card in
			float mouseX = Gdx.input.getX();
			float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
			
			// Check if we mouse overed the hand
			mouseOverHand = (mouseX >= x && mouseX <= x + fullHandWidth && mouseY >= y && mouseY <= y + Card.cardHeight);
			if (mouseOverHand) {
				
				// Which card was hovered?
				if (mouseX <= x + Card.cardWidth) {
					hoveredCardId = 0;
				} else {
					int mouseXStart = (int)(mouseX - x - Card.cardWidth);
					hoveredCardId = (int)(mouseXStart / cardOffsetX) + 1;
				}
				
				if (input.leftMouseJustClicked && matchScreen.getCardOnMouse() == null) {
					// Clicks
					Card selectedCard = hand.get(hoveredCardId);
					matchScreen.setCardOnMouse(selectedCard);
					hand.remove(selectedCard);
				}
				
			}
			
			for (Card c : hand) {
				c.update();
			}
		}
	}
	
	public void render(MatchScreen matchScreen) {
		
		if (isHuman) {

			// Player's hand
			for (int i = hand.size() - 1; i >= 0; i--) {
				if (mouseOverHand == false || matchScreen.getCardOnMouse() != null) {
					hand.get(i).render(x + (cardOffsetX * i), y);
				} else if (hoveredCardId != i) {
					hand.get(i).render(x + (cardOffsetX * i), y);
				}
			}
			
			// Hovered card pops out
			if (mouseOverHand && matchScreen.getCardOnMouse() == null && hoveredCardId < hand.size()) {
				Card hoveredCard = hand.get(hoveredCardId);
				hoveredCard.render(x + (cardOffsetX * hoveredCardId), y + 20f);
			}
			
		} else {
			
			// Opponent's hand
			for (int i = 0; i < hand.size(); i++) {
				hand.get(i).render(x + (cardOffsetX * i), y);
			}
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

	public boolean isMouseOverHand() {
		return mouseOverHand;
	}

	public void setMouseOverHand(boolean mouseOverHand) {
		this.mouseOverHand = mouseOverHand;
	}

	public float getFullHandWidth() {
		return fullHandWidth;
	}

	public int getHoverCardId() {
		return hoveredCardId;
	}
	
	public Card getRandomCard() {
		return hand.get(new Random().nextInt(hand.size()));
	}
	
	public LinkedList<Card> getHand() {
		return hand;
	}
}
