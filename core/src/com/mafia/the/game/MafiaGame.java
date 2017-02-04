package com.mafia.the.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.the.game.GameStates.GameStateManager;
import com.mafia.the.game.GameStates.MenuState;

/**
 * author:tb
 * This class is the initial class of the game.
 * load sprites and rendering happens here.
 * This class calls the menustate, which displays the menu screen.
 */
public class MafiaGame extends ApplicationAdapter {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 680;
	private	SpriteBatch batch;
	private Music introMusic;
	private Texture testImage;
	private OrthographicCamera cam;
	private GameStateManager gsm;

	@Override
	public void create () {
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm)); //transition into menustate.
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1); //clear screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		testImage.dispose();
		introMusic.dispose();
	}
}
