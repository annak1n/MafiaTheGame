package com.mafia.the.game.player;


import java.util.ArrayList;

/**
 * Created by tb on 2/6/17.
 * Mafia class defines Mafia object.
 * Following the separation of concerns principle, this class will only handle(modify) things that are
 * directly related to Mafia. Association between mafia and civilian is not handled here.
 */

public class Mafia extends Player {

    private Boolean _isMafia;

    public Mafia(){
        super();
        _isMafia = true; //override to true because super() sets isMafia to false.
    }
    public Mafia(String name, Boolean alive, Boolean mafia){
        super(name,alive,mafia);
    }

    @Override
    public <T> int howManyAlive(ArrayList<T> list) {
        return list.size();
    }
}
