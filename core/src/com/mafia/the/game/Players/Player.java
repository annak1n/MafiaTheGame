package com.mafia.the.game.Players;

/**
 * Created by tb on 2/6/17.
 * Player is the parent class for all players.
 */

public abstract class Player {

    private String _name;
    private Boolean _alive;
    private Boolean _isMafia;

    public Player(){
        _name = "Bob";
        _alive = true;
        _isMafia = false;
    }
    public Player(String name, Boolean isAlive, Boolean isMafia){
        this._name = name;
        this._alive = isAlive;
        this._isMafia = isMafia;
    }
    public void setName(String name){
        this._name= name;
    }
    public void setAlive(Boolean alive){
        this._alive = alive;
    }
    public void setMafia(Boolean mafia){
        this._isMafia = mafia;
    }
    public String getName(){
        return this._name;
    }
    public Boolean getAlive(){
        return this._alive;
    }
    public Boolean setMafia(){
        return this._isMafia;
    }

    public abstract Boolean isAlive();
    public abstract Boolean mafiaFlag();
}
