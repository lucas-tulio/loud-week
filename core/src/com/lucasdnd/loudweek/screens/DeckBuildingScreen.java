package com.lucasdnd.loudweek.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.lucasdnd.loudweek.InputHandler;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.gameplay.Card;
import com.lucasdnd.loudweek.ui.Button;
import com.lucasdnd.loudweek.ui.CardDatabasePanel;
import com.lucasdnd.loudweek.ui.PlayerHandPanel;

public class DeckBuildingScreen implements Screen {
	
	private LoudWeek game;
	
	private Card cardOnMouse;
	
	// Deck building stuff
	private Button startButton;
	private CardDatabasePanel cardDatabasePanel;
	private PlayerHandPanel playerHandPanel;
	
	private final float margin = 32f;
	
	public DeckBuildingScreen(LoudWeek game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		startButton = new Button("Start");
		cardDatabasePanel = new CardDatabasePanel(margin * 4f, Gdx.graphics.getHeight() - margin);
		playerHandPanel = new PlayerHandPanel(Gdx.graphics.getWidth() - Card.cardWidth * 2 - margin * 2, Gdx.graphics.getHeight() - margin);
	}
	
	public void update() {

		// Card on mouse update
		if (cardOnMouse != null) {
			
			cardOnMouse.update();
			
			// Put card back
			if (game.getInputHandler().rightMouseJustClicked) {
				cardDatabasePanel.putCardBack(cardOnMouse);
				playerHandPanel.putCardBack(cardOnMouse);
				cardOnMouse = null;
			}
		}
		
		cardDatabasePanel.update(game);
		playerHandPanel.update(game);
	}

	@Override
	public void render(float delta) {
		this.update();
		
		Gdx.gl.glClearColor(135f / 255f, 180f / 255f, 59f / 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Card database
		cardDatabasePanel.render(game);
		
		// Player hand
		playerHandPanel.render(game);
		
		// UI stuff
		startButton.render();
		
		if (cardOnMouse != null) {
			cardOnMouse.render(Gdx.input.getX() - Card.cardWidth / 2f, Gdx.graphics.getHeight() - Gdx.input.getY() - Card.cardHeight / 2f);
		}
		
	}
	
	public void setCardOnMouse(Card cardOnMouse) {
		this.cardOnMouse = cardOnMouse;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
