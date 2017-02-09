package com.mafia.the.game.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.the.game.player.Civilian;

/**
 * Created by tb on 2/8/17.
 * NightState is entered from the PlayState.
 * NightState takes care of things that should only happen at night(ie killing decision, who was killed, etc)
 */

public class NightState extends State {

    private Civilian deadCivilian;
    protected NightState(com.mafia.the.game.gamestates.GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float v) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void dispose() {

    }

    /**
     * display an option for mafia to kill. should only display to mafia.
     */
    public void displayKillDecision(){

    }

    /**
     * Display to everyone, who was killed.
     */
    public void displayWhoWasKilled(){

    }
}
