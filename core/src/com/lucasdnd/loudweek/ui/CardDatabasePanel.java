package com.lucasdnd.loudweek.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
	private final float separation = 32f;
	
	private FontUtils font;
	private SpriteBatch batch;
	private ShapeRenderer uiShapeRenderer;
	
	private int currentPage;
	private Button nextPageButton, previousPageButton;
	
	public CardDatabasePanel(float x, float y) {
		
		this.x = x;
		this.y = y;
		width = Card.cardWidth * 3 + separation * 2;
		height = Card.cardHeight * 3 + separation * 2;
		
		// Basic objects
		font = new FontUtils();
		batch = new SpriteBatch();
		uiShapeRenderer = new ShapeRenderer();
		nextPageButton = new Button(">");
		previousPageButton = new Button("<");		
	}
	
	public void update() {
		
	}
	
	public void render() {
		this.update();
		
		// Render cards
		batch.begin();
		final int cardsPerPage = 9;
		for (int i = 0; i < cardsPerPage; i++) {
			
			CardModel cm = CardDatabase.get().cardModels.get(i + (cardsPerPage * currentPage));
			
			float posX = x + Card.cardWidth * (i % 3) + separation * (i % 3);
			float posY = (y - Card.cardHeight * (i / 3)) - separation / 2f * (i / 3) - Card.cardHeight;
			if (cm.isPlayerHasInCollection()) {
				batch.setColor(Color.WHITE);
				batch.draw(cm.getCardTexture().blue, posX, posY);
			} else {
				batch.setColor(Color.DARK_GRAY);
				batch.draw(cm.getCardTexture().red, posX, posY);
			}
		}
		batch.end();
	}
}
