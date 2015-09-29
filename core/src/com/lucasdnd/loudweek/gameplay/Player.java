package com.lucasdnd.loudweek.gameplay;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.Resources;

public class Player {
	
	// Position
	private float x, y;
	private final float cardOffsetX = 30f;
	private final float fullHandWidth = Card.cardWidth + (4 * cardOffsetX);
	
	// Cards
	boolean mouseOverHand = false;
	private int hoveredCardId = 0;
	private final int maxCards = 5;
	private LinkedList<Card> hand;
	
	FontUtils font;
	
	
	// Position on the screen
	private int position;
	public class Position {
		public static final int upperLeft = 0;
		public static final int lowerRight = 1;
	}
	
	public Player(int position) {
		this.position = position;
		hand = new LinkedList<Card>();
		hand.add(new Card(Resources.get().abeelha));
		hand.add(new Card(Resources.get().emptyCard));
		hand.add(new Card(Resources.get().abeelha));
		hand.add(new Card(Resources.get().emptyCard));
		hand.add(new Card(Resources.get().abeelha));
		
		if (position == Position.upperLeft) {
			x = 0f;
			y = Gdx.graphics.getHeight() - Card.cardHeight;
		} else {
			x = Gdx.graphics.getWidth() - fullHandWidth;
			y = 0f;
		}
		
		font = new FontUtils();
	}
	
	public void update() {
		
		if (position != Position.lowerRight) {
			return;
		}
		
		// Check if a card was clicked
		LoudWeek game = (LoudWeek)Gdx.app.getApplicationListener();
		InputHandler input = game.getInputHandler();
		
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
			
			if (input.leftMouseJustClicked && game.getCardOnMouse() == null) {
				// Clicks
				Card selectedCard = hand.get(hoveredCardId);
				game.setCardOnMouse(selectedCard);
				hand.remove(selectedCard);
			}
			
		}
		
		for (Card c : hand) {
			c.update();
		}
	}
	
	public void render() {
		
		if (position == Position.upperLeft) {

			// Opponent's hand
			for (int i = 0; i < hand.size(); i++) {
				hand.get(i).render(x + (cardOffsetX * i), y);
			}
			
		} else {
			
			// Player's hand
			LoudWeek game = (LoudWeek)Gdx.app.getApplicationListener();
			for (int i = hand.size() - 1; i >= 0; i--) {
				if (mouseOverHand == false || game.getCardOnMouse() != null) {
					hand.get(i).render(x + (cardOffsetX * i), y);
				} else if (hoveredCardId != i) {
					hand.get(i).render(x + (cardOffsetX * i), y);
				}
			}
			
			// Hovered card pops out
			if (mouseOverHand && game.getCardOnMouse() == null && hoveredCardId < hand.size()) {
				Card hoveredCard = hand.get(hoveredCardId);
				hoveredCard.render(x + (cardOffsetX * hoveredCardId), y + 20f);
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
}
