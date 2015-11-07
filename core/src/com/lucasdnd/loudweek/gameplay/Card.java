package com.lucasdnd.loudweek.gameplay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.Resources;

/**
 * The game Card. It can be created by passing a CardModel object.
 * 
 * @author lucasdnd
 *
 */
public class Card {
	
	// Card data
	private int id;
	private String name = "";
	private String text = "";
	private int type = 0;	// Creature or Field Card
	private int strength = 0;
	private int defense = 0;
	private int agility = 0;
	private int life = 0;
	
	private boolean played;
	private boolean humanOwner;
	
	// Render
	private ShapeRenderer shapeRenderer;
	private FontUtils font;
	private SpriteBatch batch;
	private CardTexture cardTexture;
	
	private final float offsetRightX = -4f;
	private final float offsetRightY = -1f;
	
	private final float offsetTopX = -5f;
	private final float offsetTopY = -3f;
	
	private final float offsetLeftX = 6f;
	
	public final static int cardWidth = 168;
	public final static int cardHeight = 216;
	
	public Card(CardModel cardModel, boolean humanOwner) {
		
		font = new FontUtils();
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		
		// Read the card model and get the data
		this.id = cardModel.id;
		this.name = cardModel.name;
		this.text = cardModel.text;
		this.type = cardModel.type;
		this.strength = cardModel.strength;
		this.defense = cardModel.defense;
		this.agility = cardModel.agility;
		this.life = cardModel.life;
		this.cardTexture = cardModel.cardTexture;
		
		this.humanOwner = humanOwner;
	}
	
	public void update() {
		
	}
	
	public void render(float x, float y) {

		if (played) {
		
			// Cards on the board
			renderCard(x, y);
			renderCardNumbers(x, y);
			
		} else {
			
			// Cards on each player's hand
			if (humanOwner) {
				renderCard(x, y);
				renderCardNumbers(x, y);
			} else {
				batch.begin();
				batch.draw(Resources.get().cardBack, x, y);
				batch.end();
			}
		}
	}
	
	/**
	 * Renders the card texture (either blue or red)
	 * 
	 * @param x
	 * @param y
	 */
	private void renderCard(float x, float y) {
		
		batch.begin();
		if (humanOwner) {
			batch.draw(cardTexture.blue, x, y);
		} else {
			batch.draw(cardTexture.red, x, y);
		}
		batch.end();
	}
	
	/**
	 * Renders the card numbers
	 * 
	 * @param x
	 * @param y
	 */
	private void renderCardNumbers(float x, float y) {
		
		if (type == CardModel.FIELD) {
			return;
		}
		
		// Strength (right)
		font.drawWhiteFont("" + strength,
				x + cardWidth - Resources.get().whiteFont.getSpaceWidth() + offsetRightX,
				y + cardHeight / 2f + Resources.get().whiteFont.getLineHeight() / 2f + offsetRightY,
				true);
		
		// Agility (top)
		font.drawWhiteFont("" + agility,
				x + cardWidth / 2f + offsetTopX,
				y + cardHeight + offsetTopY,
				true);
		
		// Defense (left)
		font.drawWhiteFont("" + defense,
				x + offsetLeftX,
				y + cardHeight / 2f + Resources.get().whiteFont.getLineHeight() / 2f + offsetRightY,
				true);
		
		// Life (bot)
		font.drawWhiteFont("" + life,
				x + cardWidth / 2f + offsetTopX,
				y + Resources.get().whiteFont.getLineHeight(),
				true);
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public boolean isHumanOwner() {
		return humanOwner;
	}

	public void setHumanOwner(boolean humanOwner) {
		this.humanOwner = humanOwner;
	}

	public void setPlayed(boolean played) {
		this.played = played;
	}

	public int getType() {
		return type;
	}

	public CardTexture getCardTexture() {
		return cardTexture;
	}

	public void setCardTexture(CardTexture cardTexture) {
		this.cardTexture = cardTexture;
	}
	
	
}
