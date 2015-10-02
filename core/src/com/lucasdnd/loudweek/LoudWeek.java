package com.lucasdnd.loudweek;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.lucasdnd.loudweek.gameplay.Board;
import com.lucasdnd.loudweek.gameplay.Card;
import com.lucasdnd.loudweek.gameplay.Match;
import com.lucasdnd.loudweek.gameplay.Player;
import com.lucasdnd.loudweek.gameplay.Player.Position;

public class LoudWeek extends ApplicationAdapter {
	
	public static final String GAME_NAME = "Besdiário";
	public static final String VERSION = "v0.1.0";
	public static boolean debug = false;
	
	FontUtils font;
	
	// Input
	private InputHandler inputHandler;
	
	// Game objects
	private Match match;
	private Board board;
	private Card cardOnMouse;
	private Player humanPlayer, aiPlayer;
	
	@Override
	public void create () {
		
		font = new FontUtils();
		
		inputHandler = new InputHandler();
		Gdx.input.setInputProcessor(inputHandler);
		
		humanPlayer = new Player(Position.lowerRight);
		aiPlayer = new Player(Position.upperLeft);
		match = new Match(humanPlayer, aiPlayer);
		
		board = new Board();
	}
	
	private void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.D)) {
			debug = !debug;
		}
	}
	
	public void update() {
		
		handleInput();
		
		// Game Objects
		board.update(this);
		match.update(this);
		
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
		
		humanPlayer.render(this);
		aiPlayer.render(this);
		
		if (cardOnMouse != null) {
			cardOnMouse.render(Gdx.input.getX() - Card.cardWidth / 2f, Gdx.graphics.getHeight() - Gdx.input.getY() - Card.cardHeight / 2f);
		}
		
		if (debug) {
			font.drawWhiteFont("mouseX: " + Gdx.input.getX(), 0f, Gdx.graphics.getHeight() - 0f, false);
			font.drawWhiteFont("mouseY: " + Gdx.input.getY(), 0f, Gdx.graphics.getHeight() - 20f, false);
			
			font.drawWhiteFont("x: " + humanPlayer.getX(), 0f, Gdx.graphics.getHeight() - 40f, false);
			font.drawWhiteFont("y: " + humanPlayer.getY(), 0f, Gdx.graphics.getHeight() - 60f, false);
			font.drawWhiteFont("fullHandWidth: " + humanPlayer.getFullHandWidth(), 0f, Gdx.graphics.getHeight() - 80f, false);
			font.drawWhiteFont("cardHeight: " + Card.cardHeight, 0f, Gdx.graphics.getHeight() - 100f, false);
			font.drawWhiteFont("mouse over hand: " + humanPlayer.isMouseOverHand(), 0f, Gdx.graphics.getHeight() - 140f, false);
			font.drawWhiteFont("hoverCardId: " + humanPlayer.getHoverCardId(), 0f, Gdx.graphics.getHeight() - 180f, false);
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
	
	public Board getBoard() {
		return board;
	}

	public Match getMatch() {
		return match;
	}
}
