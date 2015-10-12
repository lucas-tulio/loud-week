package com.lucasdnd.loudweek.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.gameplay.Board;
import com.lucasdnd.loudweek.gameplay.Card;
import com.lucasdnd.loudweek.gameplay.Match;
import com.lucasdnd.loudweek.gameplay.Player;
import com.lucasdnd.loudweek.gameplay.Player.Position;

public class MatchScreen implements Screen {
	
	private LoudWeek game;
	
	// Game objects
	private Match match;
	private Board board;
	private Card cardOnMouse;
	private Player humanPlayer, aiPlayer;
	
	private FontUtils font;
	
	public MatchScreen(LoudWeek game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		font = new FontUtils();
		
		humanPlayer = new Player(Position.lowerRight);
		aiPlayer = new Player(Position.upperLeft);
		match = new Match(humanPlayer, aiPlayer);
		board = new Board();
	}
	
	public void update() {
		
		// Game Objects
		board.update(this);
		match.update(this);
		
		if (cardOnMouse != null) {
			cardOnMouse.update();
			if (game.getInputHandler().rightMouseJustClicked) {
				humanPlayer.getHand().add(cardOnMouse);
				cardOnMouse = null;
			}
		}
		
	}

	@Override
	public void render(float delta) {
		this.update();
		
		board.render();
		
		humanPlayer.render(this);
		aiPlayer.render(this);
		
		if (cardOnMouse != null) {
			cardOnMouse.render(Gdx.input.getX() - Card.cardWidth / 2f, Gdx.graphics.getHeight() - Gdx.input.getY() - Card.cardHeight / 2f);
		}
		
		match.render();
		
		if (game.isDebug()) {
			font.drawWhiteFont("player turn: " + match.isHumanPlayerturn(), 0f, Gdx.graphics.getHeight() - 0f, false);
			font.drawWhiteFont("ai ticks: " + match.getAiTicks(), 0f, Gdx.graphics.getHeight() - 20f, false);
		}
		
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
	
	public LoudWeek getGame() {
		return game;
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {}

}
