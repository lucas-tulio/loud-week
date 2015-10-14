package com.lucasdnd.loudweek;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.lucasdnd.loudweek.gameplay.CardTexture;

/**
 * Loads Resources and makes them available for the rest of the project.
 * 
 * @author lucasdnd
 *
 */
public class Resources {
	
	private static Resources instance;
	public static Resources get() {
		if (instance == null) {
			instance = new Resources();
		}
		return instance;
	}
	
	private Resources() {
		
		fieldCardOne = new CardTexture(new Texture("img/Campo1.png"), new Texture("img/Campo1.png"));
		fieldCardTwo = new CardTexture(new Texture("img/Campo2.png"), new Texture("img/Campo2.png"));
		
		abeelhaFofo = new CardTexture(new Texture("img/Abeelha_Azul_1.png"), new Texture("img/Abeelha_Vermelho_1.png"));
		abeelhaAberracao = new CardTexture(new Texture("img/Abeelha_Azul_2.png"), new Texture("img/Abeelha_Vermelho_2.png"));
		dragonsai = new CardTexture(new Texture("img/Dragonsai_Azul_Dragão.png"), new Texture("img/Dragonsai_Vermelhol_Dragão.png"));
		elemental = new CardTexture(new Texture("img/Elemental_Azul_Entidade.png"), new Texture("img/Elemental_Vermelho_Entidade.png"));
		ent = new CardTexture(new Texture("img/Ent_Azul_Guerreiro.png"), new Texture("img/Ent_Vermelhol_Guerreiro.png"));
		golem = new CardTexture(new Texture("img/Golem_Azul_Aberração.png"), new Texture("img/Golem_Vermelho_Aberração.png"));
		
		cardBack = new Texture("img/Verso.png");
		boardTexture = new Texture("img/Tabuleiro_fundo.png");
		
		whiteFont = new BitmapFont(Gdx.files.internal("font/proggyWhite.fnt"));
		blackFont = new BitmapFont(Gdx.files.internal("font/proggyBlack.fnt"));
		lightGrayFont = new BitmapFont(Gdx.files.internal("font/proggyLightGray.fnt"));
		grayFont = new BitmapFont(Gdx.files.internal("font/proggyGray.fnt"));
		redFont = new BitmapFont(Gdx.files.internal("font/proggyRed.fnt"));
		greenFont = new BitmapFont(Gdx.files.internal("font/proggyGreen.fnt"));
	}
	
	// Card Textures
	public CardTexture abeelhaFofo;
	public CardTexture abeelhaAberracao;
	public CardTexture fieldCardOne, fieldCardTwo;
	public CardTexture dragonsai;
	public CardTexture elemental;
	public CardTexture ent;
	public CardTexture golem;
	
	// Textures
	public Texture cardBack;
	public Texture boardTexture;
	
	// Fonts
	public BitmapFont whiteFont;
	public BitmapFont blackFont;
	public BitmapFont lightGrayFont;
	public BitmapFont grayFont;
	public BitmapFont redFont;
	public BitmapFont greenFont;
}
