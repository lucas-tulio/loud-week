package com.lucasdnd.loudweek.gameplay;

/**
 * The card model
 * @author lucasdnd
 *
 */
public class CardModel {

	protected int id;
	protected String name;
	protected int type;
	public static int CREATURE = 0;
	public static int FIELD = 1;
	protected int strength, defense, agility, life;
	protected String text;
	protected CardTexture cardTexture;
	public CardModel(int id, String name, int type, int strength, int defense,
			int agility, int life, String text, CardTexture cardTexture) {
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
	}
}