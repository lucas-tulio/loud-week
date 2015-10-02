package com.lucasdnd.loudweek.gameplay;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Align;
import com.lucasdnd.loudweek.FontUtils;
import com.lucasdnd.loudweek.LoudWeek;

public class Match {
	
	private Player humanPlayer;
	private Player aiPlayer;
	
	private FontUtils font;
	
	private boolean humanPlayerTurn;
	private long aiTicks;
	private long maxAiTicks = 300l;
	
	public Match(Player humanPlayer, Player aiPlayer) {
		
		font = new FontUtils();
		
		this.humanPlayer = humanPlayer;
		this.aiPlayer = aiPlayer;
		
		humanPlayerTurn = new Random().nextBoolean();
	}
	
	public void update(LoudWeek game) {
		
		if (humanPlayerTurn) {
			humanPlayer.update(game);
		} else {
			aiTicks++;
			if (aiTicks % maxAiTicks == 0) {
				humanPlayerTurn = true;
			}
			aiPlayer.update(game);
		}
	}
	
	public void render() {
		if (humanPlayerTurn == false) {
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
