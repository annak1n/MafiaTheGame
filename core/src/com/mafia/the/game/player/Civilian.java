package com.mafia.the.game.player;


import java.util.ArrayList;

import static com.badlogic.gdx.Input.Keys.T;

/**
 * Created by tb on 2/6/17.
 * Civilian class defines civilians(innocents).
 * Following the separation of concerns, this class will only consider things that are directly
 * related to the civilians. Association between mafia and civilian is not handled here.
 */

public class Civilian extends Player {
    private Boolean _alive;
    private Boolean _isMafia = false;

    public Civilian(){
        super();
    }
    public Civilian(String name, Boolean alive, Boolean mafia){
        super(name,alive,mafia);
    }

    @Override
    public <T> int howManyAlive(ArrayList<T> list) {
        return list.size();
    }

    /**
     * During the "Day" phase, civilians are allowed to pick a person who they believe is a mafia.
     * killMafia is only called when the person chosen by civilians is indeed a mafia.
     * @param criminal mafia character picked by civilians.
     */
    public void killMafia(Mafia mafia){
        mafia.setAliveOrDead(false);
        String killedMafia = mafia.getName(); //display to everyone who was killed.
    }
}
