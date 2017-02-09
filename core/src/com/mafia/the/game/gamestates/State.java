package com.mafia.the.game.gamestates;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by tb on 2/3/17.
 */

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm; //manage the states.
    public boolean playingState;

    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }
    protected abstract void handleInput();
    public abstract void update(float dt); //take in a delta time, difference in between frames.
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
