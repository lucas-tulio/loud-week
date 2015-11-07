package com.lucasdnd.loudweek.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.gameplay.Card;
import com.lucasdnd.loudweek.ui.Button;
import com.lucasdnd.loudweek.ui.CardDatabasePanel;
import com.lucasdnd.loudweek.ui.PlayerHandPanel;

public class DeckBuildingScreen implements Screen {
	
	private LoudWeek game;
	
	private Card cardOnHand;
	
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
		cardDatabasePanel = new CardDatabasePanel(margin * 2f, Gdx.graphics.getHeight() - margin);
		playerHandPanel = new PlayerHandPanel(Gdx.graphics.getWidth() - Card.cardWidth * 2 - margin * 2, Gdx.graphics.getHeight() - margin);
	}
	
	public void update() {
		
	}

	@Override
	public void render(float delta) {
		this.update();
		
		Gdx.gl.glClearColor(135f / 255f, 180f / 255f, 59f / 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Card database
		cardDatabasePanel.render();
		
		// Player hand
		playerHandPanel.render();
		
		// UI stuff
		startButton.render();
		
		if (cardOnHand != null) {
			cardOnHand.render(Gdx.input.getX(), Gdx.input.getY());
		}
		
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
