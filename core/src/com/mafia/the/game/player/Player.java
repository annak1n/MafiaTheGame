package com.mafia.the.game.player;

import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

/**
 * Created by tb on 2/6/17.
 * Player is the parent class for all players.
 */

public abstract class Player {

    private String _name;
    private Boolean _alive;
    private Boolean _isMafia;

    private Vector3 _position; //each character's position on screen.

//    private Animation characterAnimation; //character animation if applicable.

    public Player(){
        _name = "Bob";
        _alive = true;
        _isMafia = false;
        _position = new Vector3();
    }
    public Player(String name, Boolean isAlive, Boolean isMafia){
        this._name = name;
        this._alive = isAlive;
        this._isMafia = isMafia;
        this._position = new Vector3();
    }
    public void setName(String name){
        this._name= name;
    }
    public void setAliveOrDead(Boolean alive){
        this._alive = alive;
    }
    public void setMafia(Boolean mafia){
        this._isMafia = mafia;
    }
    public void setPosition(Vector3 pos){
        this._position = pos;
    }
    public void setPosition(float x, float y, float z){
        this._position.add(x,y,z);
    }
    public Vector3 getPosition(){
        return this._position;
    }
    public String getName() {
        return this._name;
    }
    public Boolean getAlive(){
        return this._alive;
    }
    public Boolean setMafia(){
        return this._isMafia;
    }

    public Boolean isAlive(){
        return this.getAlive();
    }
    public abstract <T> int howManyAlive(ArrayList<T> list); //list of mafia or civilian should be the input.
}
