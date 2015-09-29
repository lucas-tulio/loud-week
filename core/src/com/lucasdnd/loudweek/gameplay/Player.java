package com.lucasdnd.loudweek.gameplay;

import java.util.LinkedList;

public class Player {
	
	private float x, y;
	private float cardOffsetX; 
	private LinkedList<Card> hand;
	
	public Player() {
		hand = new LinkedList<Card>();
	}
	
	public void update() {
		x = 0f;
		y = 0f;
		cardOffsetX = 30f;
	}
	
	public void render() {
		for (int i = 0; i < hand.size(); i++) {
			hand.get(i).render(x + (cardOffsetX * i), y);
		}
	}
}
