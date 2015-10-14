package com.lucasdnd.loudweek.ui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.gameplay.Card;
import com.lucasdnd.loudweek.gameplay.CardDatabase;
import com.lucasdnd.loudweek.gameplay.CardModel;

/**
 * Renders the card database in the DeckBuildingScreen
 * 
 * @author lucasdnd
 *
 */
public class CardDatabasePanel {
	
	private float x, y, width, height;
	private final float margin = 30f;
	
	private FontUtils font;
	private ShapeRenderer uiShapeRenderer;
	
	private int currentPage;
	private Button nextPageButton, previousPageButton;
	
	private ArrayList<Card> cards;
	
	public CardDatabasePanel() {
		
		// Basic objects
		font = new FontUtils();
		uiShapeRenderer = new ShapeRenderer();
		nextPageButton = new Button(">");
		previousPageButton = new Button("<");
		
		// Screen position
		
		// Cards
		cards = new ArrayList<Card>();
		for (CardModel cm : CardDatabase.get().cards) {
			cards.add(new Card(cm, false));
		}
	}
	
	public void update() {
		x = margin;
		y = -margin + 38f; // plz don't
		width = Card.cardWidth * 3 + margin * 2;
		height = Card.cardHeight * 3 + margin * 2;
	}
	
	public void render() {
		this.update();
		
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		uiShapeRenderer.begin(ShapeType.Line);
		uiShapeRenderer.setColor(Color.BLACK);
		uiShapeRenderer.rect(x, y, width, height);
		uiShapeRenderer.end();
		
		
	}
}
