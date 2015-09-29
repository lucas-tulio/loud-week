package com.lucasdnd.loudweek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Resources {
	private static Resources instance;
	public static Resources get() {
		if (instance == null) {
			instance = new Resources();
		}
		return instance;
	}
	
	private Resources() {
		
		abeelha = new Texture("img/abeelha.png");
		emptyCard = new Texture("img/emptyCard.png");
		
		whiteFont = new BitmapFont(Gdx.files.internal("font/proggyWhite.fnt"));
		blackFont = new BitmapFont(Gdx.files.internal("font/proggyBlack.fnt"));
		lightGrayFont = new BitmapFont(Gdx.files.internal("font/proggyLightGray.fnt"));
		grayFont = new BitmapFont(Gdx.files.internal("font/proggyGray.fnt"));
		redFont = new BitmapFont(Gdx.files.internal("font/proggyRed.fnt"));
		greenFont = new BitmapFont(Gdx.files.internal("font/proggyGreen.fnt"));
	}
	
	// Textures
	public Texture abeelha;
	public Texture emptyCard;
	
	// Fonts
	public BitmapFont whiteFont;
	public BitmapFont blackFont;
	public BitmapFont lightGrayFont;
	public BitmapFont grayFont;
	public BitmapFont redFont;
	public BitmapFont greenFont;
}
