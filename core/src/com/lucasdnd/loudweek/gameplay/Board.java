package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.Gdx;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;

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
	}
	
	public void update() {
		
		LoudWeek game = (LoudWeek)Gdx.app.getApplicationListener();
		InputHandler input = game.getInputHandler();
		
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				
				// Check if we clicked this guy
				float y = Gdx.graphics.getHeight() - Gdx.input.getY();
				if (input.leftMouseJustClicked &&
						Gdx.input.getX() >= slots[i][j].getX() && Gdx.input.getX() <= slots[i][j].getX() + Card.cardWidth &&
						y >= slots[i][j].getY() && y <= slots[i][j].getY() + Card.cardHeight) {
					slots[i][j].update();
				}
			}
		}
	}
	
	public void render() {
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				slots[i][j].render();
			}
		}
	}
}
