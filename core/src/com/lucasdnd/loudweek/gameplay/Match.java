package com.lucasdnd.loudweek.gameplay;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Align;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.screens.MatchScreen;

/**
 * This Class controls the match flow and end game conditions.
 * 
 * @author lucasdnd
 *
 */
public class Match {
	
	private Player humanPlayer;
	private Player aiPlayer;
	
	private FontUtils font;
	
	private boolean gameOver;
	private boolean humanPlayerWon;
	
	private boolean humanPlayerTurn;
	private long aiTicks;
	private long maxAiTicks = 60l;
	
	public Match(Player humanPlayer, Player aiPlayer) {
		
		font = new FontUtils();
		
		this.humanPlayer = humanPlayer;
		this.aiPlayer = aiPlayer;
		
		humanPlayerTurn = new Random().nextBoolean();
	}
	
	public void update(MatchScreen matchScreen) {
		
		// Check if the game is over
		if (matchScreen.getBoard().getRandomEmptySlot() == null) {
			gameOver = true;
		}
		
		// Game result
		if (gameOver) {
			int humanCards = 0;
			int aiCards = 0;
			Slot[][] slots = matchScreen.getBoard().getSlots();
			for (int i = 0; i < slots.length; i++) {
				for (int j = 0; j < slots.length; j++) {
					if (slots[i][j].getCard().isHumanOwner()) {
						humanCards++;
					} else {
						aiCards++;
					}
				}
			}
			humanPlayerWon = humanCards > aiCards;
			return;
		}
		
		// Normal game
		if (humanPlayerTurn) {
			humanPlayer.update(matchScreen);
		} else {
			aiTicks++;
			if (aiTicks % maxAiTicks == 0) {
				playAiCard(matchScreen);
				humanPlayerTurn = true;
			}
		}
	}
	
	private void playAiCard(MatchScreen matchScreen) {
		
		Slot emptySlot = matchScreen.getBoard().getRandomEmptySlot();
		
		if (emptySlot == null) {
			
			gameOver = true;
			
		} else {
			
			// Play card
			Card cardToPlay = aiPlayer.getRandomCard();
			aiPlayer.getHand().remove(cardToPlay);
			emptySlot.playCard(matchScreen, cardToPlay, false);
		}
	}
	
	public void render() {
		if (gameOver) {
			String endText = "";
			if (humanPlayerWon) {
				endText = "Victory!";
			} else {
				endText = "Defeat!";
			}
			font.drawWhiteFont(endText, 0f, Gdx.graphics.getHeight() / 2f, true, Align.center, Gdx.graphics.getWidth());
		} else if (humanPlayerTurn == false) {
			font.drawWhiteFont("Opponent's turn", 0f, Gdx.graphics.getHeight() / 2f, true, Align.center, Gdx.graphics.getWidth());
		}
	}

	public boolean isHumanPlayerturn() {
		return humanPlayerTurn;
	}

	public void passTurn() {
		humanPlayerTurn = !humanPlayerTurn;
	}

	public long getAiTicks() {
		return aiTicks;
	}
}
