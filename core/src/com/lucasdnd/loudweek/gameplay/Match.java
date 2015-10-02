package com.lucasdnd.loudweek.gameplay;

import java.util.Random;

import com.lucasdnd.loudweek.LoudWeek;

public class Match {
	
	private Player humanPlayer;
	private Player aiPlayer;
	
	private boolean humanPlayerTurn;
	private long aiTicks;
	private long maxAiTicks = 60l;
	
	public Match(Player humanPlayer, Player aiPlayer) {
		
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

	public boolean isHumanPlayerturn() {
		return humanPlayerTurn;
	}
}
