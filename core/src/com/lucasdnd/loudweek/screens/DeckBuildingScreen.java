package com.lucasdnd.loudweek.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Screen;
import com.lucasdnd.loudweek.LoudWeek;
import com.lucasdnd.loudweek.gameplay.Card;
import com.lucasdnd.loudweek.ui.Button;
import com.lucasdnd.loudweek.ui.CardDatabasePanel;

public class DeckBuildingScreen implements Screen {
	
	private LoudWeek game;
	
	private Card cardOnHand;
	
	// Deck building stuff
	private Button startButton;
	private CardDatabasePanel cardDatabasePanel;
	private ArrayList<Card> hand;

	public DeckBuildingScreen(LoudWeek game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		startButton = new Button("Start");
		cardDatabasePanel = new CardDatabasePanel();
		hand = new ArrayList<Card>();
	}
	
	public void update() {
		
	}

	@Override
	public void render(float delta) {
		this.update();
		
		// Card database
		cardDatabasePanel.render();
		
		// Player hand
		
		
		// UI stuff
		startButton.render();
		
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
