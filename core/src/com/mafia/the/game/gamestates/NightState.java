package com.mafia.the.game.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.the.game.player.Civilian;

/**
 * Created by tb on 2/8/17.
 * NightState is entered from the PlayState.
 * NightState takes care of things that should only happen at night(ie killing decision, who was killed, etc)
 */

public class NightState extends State {


    protected NightState(com.mafia.the.game.gamestates.GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float v) {

        /*
        The only thing that game allows during the day state is mafia's killing one civilian.
        during a time frame, 2-3mins, let mafias decide on who to kill.
        when decision is made, kill the civilian.
         */

        //FIRST, CHECK NUMBER OF MAFIA AND CIVILIANS, IF ANY OF THEM IS 0, QUIT GAME.

        //LET THE MAFIA DECIDE WHO TO KILL.

        //KILL CIVILIAN.

        //MOVE TO DAY STATE.
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
    /**
     * at night, killCivilian will be called at least once, and per method call,
     * one civilian of choosing will die.
     * @param victim a civilian object, which mafia is going to kill
     */
    public void killCivilian(Civilian victim){
        victim.setAliveOrDead(false); //civilian just got killed.
    }
}
