package com.lucasdnd.loudweek.gameplay;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.lucasdnd.loudweek.Resources;

/**
 * This kinda sucks, but I have no time
 * @author lucasdnd
 *
 */
public class CardDatabase {
	
	private static CardDatabase instance;
	public static CardDatabase get() {
		if (instance == null) {
			instance = new CardDatabase();
		}
		return instance; 
	}
	
	private static ArrayList<CardModel> cards;
	
	private CardDatabase() {
		cards = new ArrayList<CardModel>();
		cards.add(new CardModel(0, "Abeelha", 2, 1, 5, 3, "", Resources.get().abeelha1));
		cards.add(new CardModel(1, "Dragonsai", 5, 2, 3, 3, "", Resources.get().abeelha1));
		cards.add(new CardModel(1, "Golem de Túmulos", 3, 3, 2, 5, "", Resources.get().abeelha1));
		cards.add(new CardModel(1, "Soldado Ent", 3, 4, 3, 3, "", Resources.get().abeelha1));
		cards.add(new CardModel(1, "Podridão Sórdida", 4, 3, 2, 4, "", Resources.get().abeelha2));
	}
	
	public CardModel getRandomCardModel() {
		return cards.get(new Random().nextInt(cards.size()));
	}
	
	public class CardModel {
		protected int id;
		protected String name;
		protected int strength, defense, agility, life;
		protected String text;
		protected Texture texture;
		public CardModel(int id, String name, int strength, int defense,
				int agility, int life, String text, Texture texture) {
			super();
			this.id = id;
			this.name = name;
			this.strength = strength;
			this.defense = defense;
			this.agility = agility;
			this.life = life;
			this.text = text;
			this.texture = texture;
		}
	}
}
