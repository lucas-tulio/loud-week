package com.lucasdnd.loudweek.gameplay;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.Resources;

public class Board {
	
	private float x, y;
	private float marginX, marginY;
	private final int boardSize = 3;
	
	private final float textureOffsetX = 14f;
	private final float textureOffsetY = 22f;
	private final float fieldCardOneTextureOffsetX = -33f;
	private final float fieldCardTwoTextureOffsetX = 28f;
	
	private Slot[][] slots;
	private Slot fieldCardOne;
	private Slot fieldCardTwo;
	
	private Texture texture;
	private SpriteBatch batch;
	
	public Board() {
		
		batch = new SpriteBatch();
		texture = Resources.get().boardTexture;
		
		marginX = (Gdx.graphics.getWidth() - (Card.cardWidth * 3)) / 2f + textureOffsetX;
		marginY = (Gdx.graphics.getHeight() - (Card.cardHeight * 3)) / 2f + textureOffsetY;
		
		x = marginX;
		y = marginY;
		slots = new Slot[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				slots[i][j] = new Slot(CardModel.CREATURE, i, j, x + Card.cardWidth * i, y + Card.cardHeight * j);
			}
		}
		
		fieldCardOne = new Slot(CardModel.FIELD, -1, -1, (marginX - Card.cardWidth) + fieldCardOneTextureOffsetX, marginY + Card.cardHeight);
		fieldCardTwo = new Slot(CardModel.FIELD, -2, -2, Gdx.graphics.getWidth() - marginX / 2f - Card.cardWidth + fieldCardTwoTextureOffsetX, marginY + Card.cardHeight);
	}
	
	public void update(LoudWeek game) {
		
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				slots[i][j].update(game);
			}
		}
		
		fieldCardOne.update(game);
		fieldCardTwo.update(game);
	}
	
	public void render() {
		
		batch.begin();
		batch.draw(texture, 1f, -1f);
		batch.end();
		
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				slots[i][j].render();
			}
		}
		
		fieldCardOne.render();
		fieldCardTwo.render();
	}
	
	public Slot[][] getSlots() {
		return slots;
	}
	
	public Slot getRandomEmptySlot() {
		ArrayList<Slot> emptySlots = new ArrayList<Slot>();
		for (int i = 0; i < slots.length; i++) {
			for (int j = 0; j < slots.length; j++) {
				if (slots[i][j].getCard() == null) {
					emptySlots.add(slots[i][j]);
				}
			}
		}
		if (emptySlots.size() == 0) {
			return null;
		}
		return emptySlots.get(new Random().nextInt(emptySlots.size()));
	}
}
