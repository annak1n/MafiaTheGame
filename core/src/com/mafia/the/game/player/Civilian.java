package com.mafia.the.game.player;


import java.util.ArrayList;

/**
 * Created by tb on 2/6/17.
 * Civilian class defines civilians(innocents).
 * Following the separation of concerns, this class will only consider things that are directly
 * related to the civilians. Association between mafia and civilian is not handled here.
 */

public class Civilian extends Player {
    private String _name;
    private Boolean _alive;
    private Boolean _isMafia = false;

    public Civilian(){
        super();
    }
    public Civilian(String name, Boolean alive, Boolean mafia){
        super(name,alive,mafia);
    }
    public void setAlive(){
        this._alive = true;
    }
    public void setDead(){
        this._alive = false;
    }

    @Override
    public Boolean isAlive() {
        return _alive;
    }

    @Override
    public Boolean mafiaFlag() {
        return _isMafia;
    }

    @Override
    public <T> int howManyAlive(ArrayList<T> list) {
        return list.size();
    }
}
