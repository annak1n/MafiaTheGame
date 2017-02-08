package com.mafia.the.game.GameStates;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
	private GameStateManager gsm;

	@Override
	public void create () {
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(0, 0, 1, 1); //clear screen
		//gsm push and set difference is that set pops the top element from stack and push new state.
		gsm.push(new MenuState(gsm)); //transition into menustate.
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
