package com.mafia.the.game.Players;


/**
 * Created by tb on 2/6/17.
 * Mafia class defines Mafia object.
 * Following the separation of concerns principle, this class will only handle(modify) things that are
 * directly related to Mafiosi. Association between mafia and civilian is not handled here.
 */

public class Mafia extends Player {

    private String _name;
    private Boolean _alive;
    private Boolean _isMafia;

    public Mafia(){
        super();
        _isMafia = true; //override to true because super() sets isMafia to false.
    }
    public Mafia(String name, Boolean alive, Boolean mafia){
        super(name,alive,mafia);
    }
    @Override
    public Boolean isAlive() {
        return _alive;
    }
    @Override
    //This is one of the mafiosi.
    public Boolean mafiaFlag() {
        return true;
    }
    /**
     * at night, killCivilian will be called at least once, and per method call,
     * one civilian of choosing will die.
     * @param victim a civilian object, which mafia is going to kill
     */
    public void killCivilian(Civilian victim){
        victim.setDead();
    }
}
