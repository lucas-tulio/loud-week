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
	protected boolean humanOwner;	// Tells if the player owns this card or not
	
	public CardModel(int id, String name, int type, int strength, int defense,
			int agility, int life, String text, CardTexture cardTexture, boolean humanOwner) {
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
		this.humanOwner = humanOwner;
	}
}