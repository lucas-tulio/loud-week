package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.Gdx;

public class Board {
	
	private float x, y;
	private float marginX, marginY;
	private final int boardSize = 3;
	
	private Slot[][] slots;
	private Slot fieldCardOne;
	private Slot fieldCardTwo;
	
	public Board() {
		
		marginX = (Gdx.graphics.getWidth() - (Card.cardWidth * 3)) / 2f;
		marginY = (Gdx.graphics.getHeight() - (Card.cardHeight * 3)) / 2f;
		
		x = marginX;
		y = marginY;
		slots = new Slot[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				slots[i][j] = new Slot(x + Card.cardWidth * i, y + Card.cardHeight * j);
			}
		}
		
		fieldCardOne = new Slot((marginX - Card.cardWidth) / 2f, marginY + Card.cardHeight);
		fieldCardTwo = new Slot(Gdx.graphics.getWidth() - marginX / 2f - Card.cardWidth / 2f, marginY + Card.cardHeight);
	}
	
	public void update() {
		
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				slots[i][j].update();
			}
		}
		
		fieldCardOne.update();
		fieldCardTwo.update();
	}
	
	public void render() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				slots[i][j].render();
			}
		}
		
		fieldCardOne.render();
		fieldCardTwo.render();
	}
}
