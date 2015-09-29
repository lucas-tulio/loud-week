package com.lucasdnd.loudweek;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.lucasdnd.loudweek.gameplay.Board;
import com.lucasdnd.loudweek.gameplay.Card;

public class LoudWeek extends ApplicationAdapter {
	
	public static final String GAME_NAME = "Besdiário";
	public static final String VERSION = "v0.1.0";
	private boolean debug = true;
	
	FontUtils font;
	
	// Input
	private InputHandler inputHandler;
	
	// Game objects
	private Board board;
	private Card cardOnMouse;
	
	@Override
	public void create () {
		
		font = new FontUtils();
		
		inputHandler = new InputHandler();
		Gdx.input.setInputProcessor(inputHandler);
		
		board = new Board();
		cardOnMouse = new Card(Resources.get().abeelha);
	}
	
	public void update() {
		
		board.update();
		
		if (cardOnMouse != null) {
			cardOnMouse.update();
		}
		
		inputHandler.refreshMouseClicks();
	}

	@Override
	public void render () {
		
		this.update();
		
		Gdx.gl.glClearColor(145f / 255f, 158f / 255f, 132f / 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		board.render();
		
		if (cardOnMouse != null) {
			cardOnMouse.render(Gdx.input.getX() - Card.cardWidth, Gdx.graphics.getHeight() - Gdx.input.getY());
		}
		
		if (debug) {
//			font.drawWhiteFont("left: " + inputHandler.leftMouseJustClicked, 0f, Gdx.graphics.getHeight(), false);
		}
	}
	
	public InputHandler getInputHandler() {
		return inputHandler;
	}
	
	public Card getCardOnMouse() {
		return cardOnMouse;
	}
	
	public void setCardOnMouse(Card card) {
		this.cardOnMouse = card;
	}
}
