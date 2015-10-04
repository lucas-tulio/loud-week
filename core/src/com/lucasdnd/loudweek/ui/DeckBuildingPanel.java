package com.lucasdnd.loudweek.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.lucasdnd.loudweek.FontUtils;

public class DeckBuildingPanel {
	
	private FontUtils font;
	private ShapeRenderer uiShapeRenderer;
	
	private Button startButton, exitButton;
	
	public DeckBuildingPanel() {
		font = new FontUtils();
		uiShapeRenderer = new ShapeRenderer();
		startButton = new Button("Start");
		exitButton = new Button("Exit");
	}
}
