package com.mafia.the.game.gamestates;

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
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

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
