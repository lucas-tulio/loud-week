package com.lucasdnd.loudweek.gameplay;

/**
 * The card data model.
 * 
 * @author lucasdnd
 *
 */
public class CardModel {

	protected int id;
	protected String name;
	protected String text;
	
	protected int type;	// Creature or field
	public static int CREATURE = 0;
	public static int FIELD = 1;
	
	protected int strength, defense, agility, life;	// The 4 basic attributes
	protected CardTexture cardTexture;
	protected boolean playerHasInCollection;	// Tells if the player owns this card or not
	
	public CardModel(int id, String name, int type, int strength, int defense,
			int agility, int life, String text, CardTexture cardTexture, boolean playerHasInCollection) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.defense = defense;
		this.agility = agility;
		this.life = life;
		this.text = text;
		this.cardTexture = cardTexture;
		this.playerHasInCollection = playerHasInCollection;
	}

	public boolean isPlayerHasInCollection() {
		return playerHasInCollection;
	}

	public void setPlayerHasInCollection(boolean playerHasInCollection) {
		this.playerHasInCollection = playerHasInCollection;
	}

	public CardTexture getCardTexture() {
		return cardTexture;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public int getType() {
		return type;
	}

	public int getStrength() {
		return strength;
	}

	public int getDefense() {
		return defense;
	}

	public int getAgility() {
		return agility;
	}

	public int getLife() {
		return life;
	}
	
	
}