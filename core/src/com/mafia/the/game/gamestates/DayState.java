package com.mafia.the.game.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mafia.the.game.player.Mafia;

/**
 * Created by tb on 2/8/17.
 * DayState defines what happens during the day state only, ie)Displaying who was killed last night, Displaying options for civilians to decide who mafia is and killing the person chosen.
 */

public class DayState extends State {

    protected DayState(com.mafia.the.game.gamestates.GameStateManager gsm) {
        super(gsm);
    }

    @Override
    /**
     * FROM DAYSTATE, YOU CAN ONLY TRANSITION INTO NIGHTSTATE.
     */
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.N)){
            gsm.set(new NightState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        //CHECK NUMBER OF MAFIA AND CIVILIANS. IF ANY OF THEM IS 0, QUIT GAME.

        //DISPLAY WHO DIED THE NIGHT BEFORE TO EVERYONE.

        //LET EVERYONE DISCUSS AND DECIDE WHO THEY THINK MAFIA IS.

        //KILL THE CHOSEN PERSON.

        //IF THE CHOSEN PERSON IS MAFIA, GOOD! IF NOT, THE CHOSEN PERSON DIES HOWEVER.

        //DELETE DAY STATE AND MOVE BACK TO NIGHTSTATE.
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(0, 1, 1, 1); //clear screen
    }

    @Override
    public void dispose() {

    }
    /**
     * isMafia is to check whether the person picked by civilians is mafia or not.
     * @param mafia input character either civilian, mafia
     * @param <T> generic type, because civilians may pick a civilian as mafia.
     * @return boolean value whether civilians correctly picked one of the mafia characters or not.
     */
    public <T> Boolean isMafia(T mafia){
        if(Mafia.class.isInstance(mafia)){ //if input is mafia, then this mafia should be passed on to killMafia.
            return true;
        }else{
            //wrong decision. Civilians picked the wrong person.
            return false;
        }
    }
}
