package com.lucasdnd.loudweek.gameplay;

import java.util.ArrayList;
import java.util.Random;

import com.lucasdnd.loudweek.Resources;

/**
 * This is where we keep all the game cards as CardModels. We should use some kind of text file in the future
 * to make it easier to change these things.
 * 
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
	
	public ArrayList<CardModel> cardModels;
	
	private CardDatabase() {
		cardModels = new ArrayList<CardModel>();
		cardModels.add(new CardModel(0, "Abeelha",           CardModel.CREATURE, 2, 1, 5, 3, "", Resources.get().abeelhaFofo, true));
		cardModels.add(new CardModel(1, "Dragonsai",         CardModel.CREATURE, 5, 2, 3, 3, "", Resources.get().dragonsai,   false));
		cardModels.add(new CardModel(2, "Golem de Túmulos",  CardModel.CREATURE, 3, 3, 2, 5, "", Resources.get().golem,       true));
		cardModels.add(new CardModel(3, "Soldado Ent",       CardModel.CREATURE, 3, 4, 3, 3, "", Resources.get().ent,         true));
		cardModels.add(new CardModel(4, "Podridão Sórdida",  CardModel.CREATURE, 4, 3, 2, 4, "", Resources.get().elemental,   true));
		
		cardModels.add(new CardModel(5, "Field Card One",  CardModel.FIELD, 0, 0, 0, 0, "", Resources.get().fieldCardOne,     true));
		cardModels.add(new CardModel(6, "Field Card One",  CardModel.FIELD, 0, 0, 0, 0, "", Resources.get().fieldCardTwo,     true));
		
		cardModels.add(new CardModel(7, "Abeelha",           CardModel.CREATURE, 2, 1, 5, 3, "", Resources.get().abeelhaFofo, true));
		cardModels.add(new CardModel(8, "Dragonsai",         CardModel.CREATURE, 5, 2, 3, 3, "", Resources.get().dragonsai,   false));
		cardModels.add(new CardModel(9, "Golem de Túmulos",  CardModel.CREATURE, 3, 3, 2, 5, "", Resources.get().golem,       true));
		cardModels.add(new CardModel(10, "Soldado Ent",       CardModel.CREATURE, 3, 4, 3, 3, "", Resources.get().ent,         true));
		cardModels.add(new CardModel(11, "Podridão Sórdida",  CardModel.CREATURE, 4, 3, 2, 4, "", Resources.get().elemental,   true));
		
		cardModels.add(new CardModel(12, "Field Card One",  CardModel.FIELD, 0, 0, 0, 0, "", Resources.get().fieldCardOne,     true));
		cardModels.add(new CardModel(13, "Field Card One",  CardModel.FIELD, 0, 0, 0, 0, "", Resources.get().fieldCardTwo,     true));
	}
	
	public CardModel getRandomCardModel() {
		return cardModels.get(new Random().nextInt(cardModels.size()));
	}
}
