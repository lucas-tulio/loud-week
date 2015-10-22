package com.lucasdnd.loudweek;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.lucasdnd.loudweek.screens.DeckBuildingScreen;
import com.lucasdnd.loudweek.screens.MatchScreen;

/**
 * Main game class.
 * 
 * @author lucasdnd
 *
 */
public class LoudWeek extends Game {
	
	// Basic stuff
	public static final String GAME_NAME = "Besdiário";
	public static final String VERSION = "v0.1.0";
	public static boolean debug = false;
	
	// Screens
	private MatchScreen matchScreen;
	private DeckBuildingScreen deckBuildingScreen;
	
	// Input
	private InputHandler inputHandler;
	
	@Override
	public void create () {
		
		inputHandler = new InputHandler();
		Gdx.input.setInputProcessor(inputHandler);
		
//		deckBuildingScreen = new DeckBuildingScreen(this);
//		this.setScreen(deckBuildingScreen);
		
		matchScreen = new MatchScreen(this);
		this.setScreen(matchScreen);
		
	}
	
	private void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.D)) {
			debug = !debug;
		}
	}
	
	public void update() {
		handleInput();
		inputHandler.refreshMouseClicks();
	}
	
	@Override
	public void render () {
		
		super.render();
		
		this.update();
		this.getScreen().render(Gdx.graphics.getDeltaTime());
	}
	
	public InputHandler getInputHandler() {
		return inputHandler;
	}

	public boolean isDebug() {
		return debug;
	}
	
	
}
