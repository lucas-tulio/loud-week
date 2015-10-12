package com.lucasdnd.loudweek.gameplay;

import java.util.ArrayList;
import java.util.Random;

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
		cards.add(new CardModel(0, "Abeelha",           CardModel.CREATURE, 2, 1, 5, 3, "", Resources.get().abeelhaFofo));
		cards.add(new CardModel(1, "Dragonsai",         CardModel.CREATURE, 5, 2, 3, 3, "", Resources.get().dragonsai));
		cards.add(new CardModel(2, "Golem de Túmulos",  CardModel.CREATURE, 3, 3, 2, 5, "", Resources.get().golem));
		cards.add(new CardModel(3, "Soldado Ent",       CardModel.CREATURE, 3, 4, 3, 3, "", Resources.get().ent));
		cards.add(new CardModel(4, "Podridão Sórdida",  CardModel.CREATURE, 4, 3, 2, 4, "", Resources.get().elemental));
		
		cards.add(new CardModel(5, "Field Card One",  CardModel.FIELD, 0, 0, 0, 0, "", Resources.get().fieldCardOne));
		cards.add(new CardModel(6, "Field Card One",  CardModel.FIELD, 0, 0, 0, 0, "", Resources.get().fieldCardTwo));
	}
	
	public CardModel getRandomCardModel() {
		return cards.get(new Random().nextInt(cards.size()));
	}
}
